package com.nikitarizh.memebot.configurator;

import com.nikitarizh.memebot.service.GatewayService;
import com.pengrad.telegrambot.MemeBot;
import com.pengrad.telegrambot.UpdatesListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Slf4j
public class MemeBotConfigurator {

    private final GatewayService service;
    private final MemeBot bot;

    @PostConstruct
    public void initBot() {
        log.debug("Setting updates listener...");
        bot.setUpdatesListener(updates -> {
            service.executeAll(updates);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
        log.debug("Updates listener set");
    }
}
