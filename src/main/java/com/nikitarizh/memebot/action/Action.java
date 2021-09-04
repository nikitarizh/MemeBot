package com.nikitarizh.memebot.action;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.response.SendResponse;

public interface Action {
    SendResponse act(Update update, BotRequestEntity botRequest);
    String getBoundCommand();
    String getCommandDescription();
}
