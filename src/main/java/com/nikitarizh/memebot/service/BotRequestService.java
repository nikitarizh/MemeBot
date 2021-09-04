package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.nikitarizh.memebot.entity.User;
import com.nikitarizh.memebot.repository.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BotRequestService {

    private final RequestRepository requestRepository;

    @Transactional
    public BotRequestEntity newBotRequest(String message, User user) {
        var request = BotRequestEntity.builder()
                .user(user)
                .request(message)
                .build();
        requestRepository.save(request);
        return request;
    }
}
