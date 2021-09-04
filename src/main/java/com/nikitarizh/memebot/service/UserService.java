package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.entity.User;
import com.nikitarizh.memebot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User getByTelegramUser(com.pengrad.telegrambot.model.User tgUser) {
        var user = userRepository.findByTelegramId(tgUser.id());
        if (user.isEmpty()) {
            return createFromTelegramUser(tgUser);
        }
        return user.get();
    }

    @Transactional
    public User createFromTelegramUser(com.pengrad.telegrambot.model.User tgUser) {
        var newUser = User.builder()
                .telegramUsername(tgUser.username())
                .telegramId(tgUser.id())
                .firstName(tgUser.firstName())
                .lastName(tgUser.lastName())
                .build();
        userRepository.save(newUser);
        return newUser;
    }
}
