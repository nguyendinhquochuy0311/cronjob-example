package com.common.base.model.constant;

import lombok.Getter;

@Getter
public enum ItachiStatusCode {
    OK(200, "Success"),
    BAD_REQUEST(400, "Bad request!"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Access denied!"),
    NOT_FOUND(404, "Not found");

    private int status;
    private String message;

    ItachiStatusCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}