package com.nikitarizh.memebot.entity;

import com.nikitarizh.memebot.exception.FailedRequestToTelegramException;
import com.nikitarizh.memebot.service.BotResponseService;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

import static com.nikitarizh.memebot.entity.ResponseStatus.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemeBot {

    @Value("${bot.token}")
    private String token;
    private TelegramBot bot;

    private final BotResponseService responseService;

    @PostConstruct
    private void init() {
        bot = new TelegramBot(token);
    }

    public TelegramBot getCoreBot() {
        return bot;
    }

    @Transactional
    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(BaseRequest<T, R> request,
                                                                           UserResponse response,
                                                                           BotRequestEntity botRequest) {
        var responseEntity = responseService.newBotResponse(botRequest.getUser(), botRequest, response.getResponseText());
        responseEntity.setResponseStatus(PENDING);

        R botResponse;
        try {
            botResponse = bot.execute(request);
        } catch (Exception e) {
            log.error("Failed request to telegram", e);
            responseEntity.setResponseStatus(FAILED);
            throw new FailedRequestToTelegramException(e);
        }

        responseEntity.setResponseStatus(OK);
        return botResponse;
    }
}
