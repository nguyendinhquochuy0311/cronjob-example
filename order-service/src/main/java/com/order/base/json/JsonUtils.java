package com.order.base.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Collections;
import java.util.Map;

public class JsonUtils {

    public static <T> String objectToJsonStr(T value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static <T> T jsonStrToObject(String value, Class<T> objectType) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(value, objectType);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    public static Map<String, Object> jsonStrToMap(String value) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(value, new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            return Collections.emptyMap();
        }
    }

    private JsonUtils() {
    }
}
