package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService {
    private final String apiUrl = "https://chat.openai.com/";
    private final String apiKey = "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";

    private final RestTemplate restTemplate;

    public ChatGPTService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String callChatGpt(String prompt) {
        String requestJson = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 50}";

        return restTemplate.postForObject(apiUrl, requestJson, String.class);
    }
}
