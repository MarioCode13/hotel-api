package org.hotel.hotel.mapper;

import org.hotel.hotel.dto.RoomDTO;
import org.hotel.hotel.model.Room;

public class RoomDTOMapper {

    public static RoomDTO toDto(Room room) {
        return new RoomDTO(
                room.getId(),
                room.getRoomNumber(),
                room.getType(),
                room.getPricePerNight()
        );
    }
}
