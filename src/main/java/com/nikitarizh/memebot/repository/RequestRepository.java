package com.nikitarizh.memebot.repository;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<BotRequestEntity, Long> {
}
