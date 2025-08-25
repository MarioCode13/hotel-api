package org.hotel.hotel.mapper;

import org.hotel.hotel.dto.UserDTO;
import org.hotel.hotel.model.User;

public class UserDTOMapper {

    public static UserDTO toDto(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}