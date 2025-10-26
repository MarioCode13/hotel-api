package org.hotel.hotel.repository;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hotel.hotel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Object> findByEmail(@NotBlank @Email String email);
}
