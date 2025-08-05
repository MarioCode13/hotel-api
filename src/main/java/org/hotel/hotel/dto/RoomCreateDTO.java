package org.hotel.hotel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RoomCreateDTO(
        @NotBlank String roomNumber,
        @NotBlank String type,
        @NotNull double pricePerNight,
        @NotNull Long hotelId
) {}
