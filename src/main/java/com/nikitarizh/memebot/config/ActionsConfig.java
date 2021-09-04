package com.nikitarizh.memebot.config;

import com.nikitarizh.memebot.action.Action;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class ActionsConfig {

    private final List<Action> actions;

    @Bean
    @Primary
    @Qualifier("commandToAction")
    public Map<String, Action> stringActionMap() {
        return actions.stream().collect(Collectors.toMap(Action::getBoundCommand, Function.identity()));
    }
}
