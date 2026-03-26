package com.nh.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nh.userservice.model.Client;

/**
 * Data access layer
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
