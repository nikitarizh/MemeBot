package com.nikitarizh.memebot.config;

import com.pengrad.telegrambot.TelegramBot;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class BotConfig {

    @Value("${bot.token}")
    private String token;

    @Bean
    @SneakyThrows
    public TelegramBot telegramBot() {
        return new TelegramBot(token);
    }
}
