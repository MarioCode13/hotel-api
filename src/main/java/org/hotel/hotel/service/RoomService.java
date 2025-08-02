package org.hotel.hotel.service;

import org.hotel.hotel.dto.RoomDTO;
import org.hotel.hotel.mapper.RoomDTOMapper;
import org.hotel.hotel.model.Room;
import org.hotel.hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public List<RoomDTO> getAllRooms() {
        return roomRepository.findAll().stream()
                .map(RoomDTOMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<RoomDTO> getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .map(RoomDTOMapper::toDto);
    }

    public List<RoomDTO> findByHotelId(Long hotelId) {
        return roomRepository.findByHotelId(hotelId).stream()
                .map(RoomDTOMapper::toDto)
                .collect(Collectors.toList());
    }

}
