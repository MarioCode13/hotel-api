package org.hotel.hotel.mapper;

import org.hotel.hotel.dto.BookingDTO;
import org.hotel.hotel.model.Booking;

public class BookingDTOMapper {

    public static BookingDTO toDto(Booking booking) {
        return new BookingDTO(
                booking.getId(),
                booking.getUser().getId(),
                booking.getRoom().getId(),
                booking.getCheckIn(),
                booking.getCheckOut()
        );
    }
}