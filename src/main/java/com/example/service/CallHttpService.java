package com.example.service;

import com.example.model.Request;
import com.example.model.Response;
import com.example.utils.WebClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

@Service
public class CallHttpService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Call example đơn giản
     * Viết interface cho class này để inject vào Các service khác sài
     * chỉnh sử request response và token
     * domain và path nên lấy trong file application.properties
     * <p>
     * đọc rồi sửa theo đúng yêu cầu mình cần
     */

    public Response callChatGpt(Request payload, String token) {
        var client = WebClientUtils.getWebClient("domain");
        return client
                .method(HttpMethod.POST)
                .uri("/path")
                .header("token", token)
                .body(BodyInserters.fromObject(payload))
                .retrieve()
                .bodyToMono(Response.class)
                .doOnSuccess(s -> logger.info("[callChatGpt] response data: {}", s.getData()))
                .doOnError(t -> logger.error("[callChatGpt] error: {}", t.getMessage()))
                .block(Duration.ofSeconds(90));
    }

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // JSON content to send
        String json = "{\"contents\":[{\"role\":\"user\",\"parts\":[{\"text\":\"Write a story about a magic backpack.\"}]}]}";

        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        // Send request and retrieve response
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "https://generativelanguage.googleapis.com/v1/models/gemini-pro:streamGenerateContent?key=AIzaSyAMWtfwsuIPulFMID_SYDc90quz8gjKLGo",
                requestEntity,
                String.class);

        // Save response to a file
        try (FileWriter fileWriter = new FileWriter("response.json")) {
            fileWriter.write(Objects.requireNonNull(responseEntity.getBody()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
