package org.hotel.hotel.dto;

import java.time.LocalDate;

public record BookingDTO(
        Long id,
        Long userId,
        Long roomId,
        LocalDate checkIn,
        LocalDate checkOut
) {}


