package com.nikitarizh.memebot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendPhoto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExecutionService {

    private final TelegramBot bot;
    private final MemeService memeService;

    public void executeAll(List<Update> updates) {
        updates.forEach(this::execute);
    }

    public void execute(Update update) {
        var messageRequest = new SendPhoto(update.message().chat().id(), memeService.getMemeUrl());
        var response = bot.execute(messageRequest);
        log.info(response.toString());
    }
}
