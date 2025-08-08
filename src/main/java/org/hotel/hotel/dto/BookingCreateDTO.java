package org.hotel.hotel.dto;

import java.time.LocalDate;

public record BookingCreateDTO(
        Long userId,
        Long roomId,
        LocalDate checkIn,
        LocalDate checkOut
) {
}

