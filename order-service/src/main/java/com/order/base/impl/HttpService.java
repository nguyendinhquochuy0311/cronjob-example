package com.order.base.impl;

import com.common.base.json.JsonUtils;
import com.order.base.ServiceClient;
import com.order.utils.WebClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.Map;
import java.util.Optional;

@Service
public class HttpService implements ServiceClient {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public <T, R> T executePost(R payload, String endpoint, Map<String, String> header, Class<T> tClass) {
        var client = WebClientUtils.getWebClient(endpoint);
        return client
                .method(HttpMethod.POST)
                .uri("")
                .headers(httpHeaders -> addHeader(header, httpHeaders))
                .body(BodyInserters.fromValue(payload))
                .retrieve()
                .bodyToMono(tClass)
                .doOnSuccess(response ->
                        logger.info("[CALL-HTTP][SUCCESS] response: {}",
                                Optional.ofNullable(JsonUtils.objectToJsonStr(response))
                                        .orElse("parse response error")))
                .doOnError(t -> logger.error("[CALL-HTTP][FAILURE] message: {}", t.getMessage()))
                .block();
    }

    @Override
    public <T, R> T executePost(R payload, String endpoint, Class<T> tClass) {
        return executePost(payload, endpoint, null, tClass);
    }

    private void addHeader(Map<String, String> header, HttpHeaders httpHeaders) {
        if (header != null) {
            httpHeaders.setAll(header);
        }
    }

    public HttpService() {
    }
}
