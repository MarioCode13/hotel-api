package org.hotel.hotel.service;

import org.hotel.hotel.dto.UserCreateDTO;
import org.hotel.hotel.dto.UserDTO;
import org.hotel.hotel.exceptions.user.EmailAlreadyExistsException;
import org.hotel.hotel.exceptions.user.UserNotFoundException;
import org.hotel.hotel.mapper.UserDTOMapper;
import org.hotel.hotel.model.User;
import org.hotel.hotel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserDTOMapper::toDto)
                .toList();
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserDTOMapper::toDto);
    }

    @Transactional
    public UserDTO createUser(UserCreateDTO dto) {
        userRepository.findByEmail(dto.email())
                .ifPresent(u -> { throw new EmailAlreadyExistsException(dto.email()); });
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return UserDTOMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public UserDTO updateUser(Long id, UserCreateDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setName(dto.name());
        user.setEmail(dto.email());

        return UserDTOMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
