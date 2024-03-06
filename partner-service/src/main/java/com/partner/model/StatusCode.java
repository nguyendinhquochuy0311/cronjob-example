package com.partner.model;

import lombok.Getter;

@Getter
public enum StatusCode {
    OK(200, "Success"),
    BAD_REQUEST(400, "Bad request!"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Access denied!"),
    NOT_FOUND(404, "Not found");

    private int status;
    private String message;

    StatusCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}