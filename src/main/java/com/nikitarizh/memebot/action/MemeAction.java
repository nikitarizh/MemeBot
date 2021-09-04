package com.nikitarizh.memebot.action;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.nikitarizh.memebot.entity.MemeBot;
import com.nikitarizh.memebot.entity.UserResponse;
import com.nikitarizh.memebot.service.MemeService;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemeAction implements Action {

    private final MemeService memeService;
    private final MemeBot bot;

    @Override
    public SendResponse act(Update update, BotRequestEntity botRequest) {
        var memeUrl = memeService.getMemeUrl();
        var response = new UserResponse(memeService.getMemeUrl());
        var messageRequest = new SendPhoto(update.message().chat().id(), memeUrl);
        return bot.execute(messageRequest, response, botRequest);
    }

    @Override
    public String getBoundCommand() {
        return "/meme";
    }

    @Override
    public String getCommandDescription() {
        return "Get random meme";
    }
}
