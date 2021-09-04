package com.nikitarizh.memebot.service;

import com.nikitarizh.memebot.dto.MemeResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MemeService {

    private final RestTemplate restTemplate;

    public String getMemeUrl() {
        var response = restTemplate.getForObject("https://meme-api.herokuapp.com/gimme", MemeResponseDTO.class);
        return response.getUrl();
    }
}
