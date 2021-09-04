package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GatewayService {

    private final ExecutionService executionService;
    private final BotRequestService botRequestService;
    private final UserService userService;

    public void executeAll(List<Update> updates) {
        updates.forEach(this::execute);
    }

    private void execute(Update update) {
        var request = initRequest(update);
        executionService.execute(update, request);
    }

    private BotRequestEntity initRequest(Update update) {
        var messageText = update.message().text();
        var user = userService.getByTelegramUser(update.message().from());
        return botRequestService.newBotRequest(messageText, user);
    }
}
