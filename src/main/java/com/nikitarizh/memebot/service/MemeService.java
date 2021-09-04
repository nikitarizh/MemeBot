package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.entity.MemeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MemeService {

    private final RestTemplate restTemplate;

    public String getMemeUrl() {
        var response = restTemplate.getForObject("https://meme-api.herokuapp.com/gimme", MemeResponse.class);
        return response.getUrl();
    }
}
