package org.hotel.hotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hotel.hotel.dto.HotelDTO;

@Getter
@Setter
@Entity
public class Room {
    @Id
    @GeneratedValue
    private Long id;

    private String roomNumber;
    private String type;
    private double pricePerNight;

    @ManyToOne
    private Hotel hotel;
}