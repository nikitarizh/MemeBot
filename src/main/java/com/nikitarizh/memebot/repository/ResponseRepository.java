package com.nikitarizh.memebot.repository;

import com.nikitarizh.memebot.entity.BotResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<BotResponseEntity, Long> {
}
