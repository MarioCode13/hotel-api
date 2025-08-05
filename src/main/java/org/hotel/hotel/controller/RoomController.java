package org.hotel.hotel.controller;

import org.hotel.hotel.dto.RoomCreateDTO;
import org.hotel.hotel.dto.RoomDTO;
import org.hotel.hotel.model.Hotel;
import org.hotel.hotel.model.Room;
import org.hotel.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDTO> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RoomDTO createRoom(@RequestBody RoomCreateDTO dto) {
        return roomService.createRoom(dto);
    }
}
