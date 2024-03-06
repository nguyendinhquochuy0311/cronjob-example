package com.order.base;

import java.util.Map;

public interface ServiceClient {
    <T, R> T executePost(R payload, String endpoint, Map<String, String> header, Class<T> tClass);

    <T, R> T executePost(R payload, String endpoint, Class<T> tClass);
}
