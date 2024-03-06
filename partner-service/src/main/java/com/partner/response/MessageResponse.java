package com.partner.response;

import com.partner.model.StatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MessageResponse {

    private int status;
    private String message;
    private Object data;

    private long time = System.currentTimeMillis();

    public MessageResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public MessageResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public MessageResponse(StatusCode statusCode, Object data) {
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public MessageResponse(StatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = null;
    }

}
