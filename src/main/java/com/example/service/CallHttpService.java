package com.example.service;

import com.example.model.Request;
import com.example.model.Response;
import com.example.utils.WebClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.Duration;

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
}
