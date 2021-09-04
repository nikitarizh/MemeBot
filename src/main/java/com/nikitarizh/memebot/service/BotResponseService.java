package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.nikitarizh.memebot.entity.BotResponseEntity;
import com.nikitarizh.memebot.entity.ResponseStatus;
import com.nikitarizh.memebot.entity.User;
import com.nikitarizh.memebot.repository.ResponseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.nikitarizh.memebot.entity.ResponseStatus.CREATED;

@Service
@RequiredArgsConstructor
public class BotResponseService {

    private final ResponseRepository responseRepository;

    @Transactional
    public BotResponseEntity newBotResponse(User user, BotRequestEntity request, String responseText) {
        var response = BotResponseEntity.builder()
                .user(user)
                .request(request)
                .botResponse(responseText)
                .responseStatus(CREATED)
                .build();
        responseRepository.save(response);
        return response;
    }
}
