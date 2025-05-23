package com.astrodust.springsecurity.repository;

import com.astrodust.springsecurity.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(@Param("username") String username);
    Optional<User> findById(@Param("id") @NonNull Integer id);
}
