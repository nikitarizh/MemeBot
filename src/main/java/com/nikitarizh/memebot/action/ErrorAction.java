package com.nikitarizh.memebot.action;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.nikitarizh.memebot.entity.MemeBot;
import com.nikitarizh.memebot.entity.UserResponse;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ErrorAction implements Action {

    private final MemeBot bot;

    @Override
    public SendResponse act(Update update, BotRequestEntity botRequest) {
        var userId = update.message().from().id();
        var text = "Error occurred. Please try again later";
        var response = new UserResponse(text);
        var request = new SendMessage(userId, text);
        return bot.execute(request, response, botRequest);
    }

    @Override
    public String getBoundCommand() {
        return "error";
    }

    @Override
    public String getCommandDescription() {
        return "";
    }
}
