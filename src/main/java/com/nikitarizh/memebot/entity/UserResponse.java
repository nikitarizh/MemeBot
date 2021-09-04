package com.nikitarizh.memebot.entity;

import lombok.Getter;

@Getter
public class UserResponse {

    private final String responseText;

    public UserResponse(String responseText) {
        this.responseText = responseText;
    }
}
