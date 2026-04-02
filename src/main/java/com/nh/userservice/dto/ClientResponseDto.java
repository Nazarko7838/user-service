package com.nh.userservice.dto;

public record ClientResponseDto(
    Long id,
    String fullName,
    String licensePlate
) {}
