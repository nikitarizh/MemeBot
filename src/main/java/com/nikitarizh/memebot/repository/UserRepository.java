package com.nikitarizh.memebot.repository;

import com.nikitarizh.memebot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByTelegramId(long id);
}
