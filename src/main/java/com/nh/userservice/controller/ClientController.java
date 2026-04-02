package com.nh.userservice.controller;

import java.util.List;

import com.nh.userservice.dto.ClientRequestDto;
import com.nh.userservice.dto.ClientResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nh.userservice.service.UserService;

import jakarta.validation.Valid;

/**
 * Handles /api/clients endpoints
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final UserService userService;

    @Autowired
    public ClientController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto createClient(@Valid @RequestBody ClientRequestDto client) {
        return userService.createClient(client);
    }

    @GetMapping
    public List<ClientResponseDto> getAllClients() {
        return userService.getAllClients();
    }

    @GetMapping("/{id}")
    public ClientResponseDto getClientById(@PathVariable Long id) {
        return userService.getClientById(id);
    }

}
