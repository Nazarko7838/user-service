package com.nh.userservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Вказує, що це таблиця в БД
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматична генерація ID
    private Long id;

    @NotBlank(message = "Ім'я клієнта обов'язкове")
    private String fullName;

    @NotBlank(message = "Номерний знак обов'язковий")
    private String licensePlate;
}