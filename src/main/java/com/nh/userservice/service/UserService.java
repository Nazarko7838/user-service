package com.nh.userservice.service;

import java.util.List;

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

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
    }

}
