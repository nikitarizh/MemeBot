package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.action.Action;
import com.nikitarizh.memebot.exception.NoActionException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ActionDispatcherService {

    @Qualifier("commandToAction")
    private final Map<String, Action> commandToActionMap;

    public Action getActionForCommand(String command) {
        var action = commandToActionMap.get(command);
        if (action == null) {
            throw new NoActionException(command);
        }
        return action;
    }
}
