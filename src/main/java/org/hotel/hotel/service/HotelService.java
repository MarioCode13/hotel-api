package org.hotel.hotel.service;

import org.hotel.hotel.dto.HotelCreateDTO;
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

    public HotelDTO createHotel(HotelCreateDTO dto) {
        Hotel hotel = new Hotel();
        hotel.setName(dto.name());
        hotel.setAddress(dto.address());

        Hotel saved = hotelRepository.save(hotel);
        return HotelDTOMapper.toDto(saved);
    }

    public HotelDTO updateHotel(Long id, HotelCreateDTO dto) {
        Hotel updated = hotelRepository.findById(id)
                .map(hotel -> {
                    hotel.setName(dto.name());
                    hotel.setAddress(dto.address());
                    return hotelRepository.save(hotel);
                })
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        return HotelDTOMapper.toDto(updated);
    }


    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }


}
