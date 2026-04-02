package com.nh.userservice.dto;

import jakarta.validation.constraints.NotBlank;

public record ClientRequestDto(
    @NotBlank(message = "Ім'я клієнта обов'язкове")
    String fullName,

    @NotBlank(message = "Номерний знак обов'язковий")
    String licensePlate
) {}
