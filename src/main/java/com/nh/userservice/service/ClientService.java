package com.nh.userservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.nh.userservice.dto.ClientRequestDto;
import com.nh.userservice.dto.ClientResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nh.userservice.model.Client;
import com.nh.userservice.repository.ClientRepository;
import com.nh.userservice.exception.ResourceNotFoundException;

/**
 * Handles client business logic
 */
@Slf4j
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientResponseDto createClient(ClientRequestDto clientDto) {
        Client client = new Client();
        client.setFullName(clientDto.fullName());
        client.setLicensePlate(clientDto.licensePlate());
        Client saved = clientRepository.save(client);
        return mapClientToDto(saved);
    }


    public List<ClientResponseDto> getAllClients() {
        log.info("FETCHING ALL CLIENTS FROM DATABASE");
        return clientRepository.findAll()
                .stream()
                .map(this::mapClientToDto)
                .collect(Collectors.toList());
    }

    @Cacheable("client")
    public ClientResponseDto getClientById(Long id) {
        log.info("FETCHING CLIENT FROM DATABASE FOR ID: {}", id);
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Клієнта з ID " + id + " не знайдено"));
        return mapClientToDto(client);
    }

    private ClientResponseDto mapClientToDto(Client client) {
        if (client == null) return null;
        return new ClientResponseDto(client.getId(), client.getFullName(), client.getLicensePlate());
    }

}
