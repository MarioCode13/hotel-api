package org.hotel.hotel.service;

import org.hotel.hotel.dto.BookingCreateDTO;
import org.hotel.hotel.dto.BookingDTO;
import org.hotel.hotel.mapper.BookingDTOMapper;
import org.hotel.hotel.model.Booking;
import org.hotel.hotel.model.Room;
import org.hotel.hotel.model.User;
import org.hotel.hotel.repository.BookingRepository;
import org.hotel.hotel.repository.RoomRepository;
import org.hotel.hotel.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public BookingService(
            BookingRepository bookingRepository,
            UserRepository userRepository,
            RoomRepository roomRepository
    ) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public List<BookingDTO> getAllBookings() {
        return bookingRepository.findAll().stream()
                .map(BookingDTOMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<BookingDTO> getBookingById(Long id) {
        return bookingRepository.findById(id)
                .map(BookingDTOMapper::toDto);
    }

    public BookingDTO createBooking(BookingCreateDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepository.findById(dto.roomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setCheckIn(dto.checkIn());
        booking.setCheckOut(dto.checkOut());

        return BookingDTOMapper.toDto(bookingRepository.save(booking));
    }

    public BookingDTO updateBooking(Long id, BookingCreateDTO dto) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Room room = roomRepository.findById(dto.roomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        booking.setUser(user);
        booking.setRoom(room);
        booking.setCheckIn(dto.checkIn());
        booking.setCheckOut(dto.checkOut());

        return BookingDTOMapper.toDto(bookingRepository.save(booking));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
