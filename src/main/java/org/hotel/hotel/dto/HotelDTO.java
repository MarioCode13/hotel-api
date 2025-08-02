package org.hotel.hotel.dto;

import java.util.List;


public record HotelDTO(Long id, String name, String address, List<RoomDTO> rooms) {}
