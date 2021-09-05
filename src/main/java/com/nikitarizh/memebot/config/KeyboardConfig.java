package com.nikitarizh.memebot.config;

import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyboardConfig {

    @Bean
    public ReplyKeyboardMarkup replyKeyboardMarkup() {
        return new ReplyKeyboardMarkup(
                new KeyboardButton("/meme"),
                new KeyboardButton("/help")
        ).resizeKeyboard(true);
    }
}
