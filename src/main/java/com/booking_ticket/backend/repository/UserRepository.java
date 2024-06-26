package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    @Override
    <S extends User> S save(S entity);
}
