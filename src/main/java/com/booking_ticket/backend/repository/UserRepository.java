package com.booking_ticket.backend.repository;

import com.booking_ticket.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
//select * from User where username = ?
    Boolean existsByUsername(String username);


    @Override
    <S extends User> S save(S entity);

    @Query(value = "SELECT id FROM user WHERE username = :username", nativeQuery = true)
    Long findIdByUsername(@Param("username") String username);

}
