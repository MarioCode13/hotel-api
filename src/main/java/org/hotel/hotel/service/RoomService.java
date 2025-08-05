package org.hotel.hotel.service;

import org.hotel.hotel.dto.RoomCreateDTO;
import org.hotel.hotel.dto.RoomDTO;
import org.hotel.hotel.mapper.RoomDTOMapper;
import org.hotel.hotel.model.Hotel;
import org.hotel.hotel.model.Room;
import org.hotel.hotel.repository.HotelRepository;
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
    @Autowired
    private HotelService hotelService;
    @Autowired
    private HotelRepository hotelRepository;

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

    public RoomDTO createRoom(RoomCreateDTO dto) {
        Hotel hotel = hotelRepository.findById(dto.hotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        Room room = new Room();
        room.setRoomNumber(dto.roomNumber());
        room.setType(dto.type());
        room.setPricePerNight(dto.pricePerNight());
        room.setHotel(hotel);

        Room savedRoom = roomRepository.save(room);

        return RoomDTOMapper.toDto(savedRoom);
    }

    public RoomDTO updateRoom(Long id, RoomCreateDTO dto) {
        Hotel hotel = hotelRepository.findById(dto.hotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setRoomNumber(dto.roomNumber());
        room.setType(dto.type());
        room.setPricePerNight(dto.pricePerNight());
        room.setHotel(hotel);

        Room saved = roomRepository.save(room);
        return RoomDTOMapper.toDto(saved);
    }

}
