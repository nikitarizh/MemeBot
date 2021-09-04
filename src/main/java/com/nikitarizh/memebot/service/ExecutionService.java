package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.entity.BotRequestEntity;
import com.nikitarizh.memebot.exception.NoActionException;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExecutionService {

    private final ActionDispatcherService actionDispatcherService;

    public void execute(Update update, BotRequestEntity botRequest) {
        var messageText = update.message().text();

        try {
            actionDispatcherService.getActionForCommand(messageText).act(update, botRequest);
        } catch (NoActionException e) {
            actionDispatcherService.getActionForCommand("help").act(update, botRequest);
        } catch (Exception e) {
            log.error("Error occurred while execution", e);
            actionDispatcherService.getActionForCommand("error").act(update, botRequest);
        }
    }
}
