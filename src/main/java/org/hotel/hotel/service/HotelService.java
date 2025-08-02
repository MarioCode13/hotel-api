package org.hotel.hotel.service;

import org.hotel.hotel.dto.HotelDTO;
import org.hotel.hotel.mapper.HotelDTOMapper;
import org.hotel.hotel.model.Hotel;
import org.hotel.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<HotelDTO> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(HotelDTOMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<HotelDTO> getHotelById(Long id) {
        return hotelRepository.findById(id)
                .map(HotelDTOMapper::toDto);
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel updateHotel(Long id, Hotel updatedHotel) {
        return hotelRepository.findById(id)
                .map(hotel -> {
                    hotel.setName(updatedHotel.getName());
                    hotel.setAddress(updatedHotel.getAddress());
                    return hotelRepository.save(hotel);
                })
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }


}
