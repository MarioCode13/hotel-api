package org.hotel.hotel.mapper;

import org.hotel.hotel.dto.HotelDTO;
import org.hotel.hotel.dto.RoomDTO;
import org.hotel.hotel.model.Hotel;
import org.hotel.hotel.model.Room;
import java.util.List;

public class HotelDTOMapper {

    public static HotelDTO toDto(Hotel hotel) {
        List<RoomDTO> rooms = hotel.getRooms().stream()
                .map(HotelDTOMapper::toRoomDto)
                .toList();
        return new HotelDTO(hotel.getId(), hotel.getName(), hotel.getAddress(), rooms);
    }

    private static RoomDTO toRoomDto(Room room) {
        return new RoomDTO(room.getId(), room.getRoomNumber(), room.getType(), room.getPricePerNight());
    }
}
