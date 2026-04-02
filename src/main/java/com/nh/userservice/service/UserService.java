package com.nh.userservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.nh.userservice.dto.ClientRequestDto;
import com.nh.userservice.dto.ClientResponseDto;
import org.springframework.stereotype.Service;

import com.nh.userservice.model.Client;
import com.nh.userservice.repository.ClientRepository;
import com.nh.userservice.exception.ResourceNotFoundException;

/**
 * Handles client business logic
 */
@Service
public class UserService {

    private final ClientRepository clientRepository;

    public UserService(ClientRepository clientRepository) {
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
        return clientRepository.findAll()
                .stream()
                .map(this::mapClientToDto)
                .collect(Collectors.toList());
    }

    public ClientResponseDto getClientById(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Клієнта з ID " + id + " не знайдено"));
        return mapClientToDto(client);
    }

    private ClientResponseDto mapClientToDto(Client client) {
        if (client == null) return null;
        return new ClientResponseDto(client.getId(), client.getFullName(), client.getLicensePlate());
    }

}
