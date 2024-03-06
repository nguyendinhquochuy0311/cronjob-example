package com.common.base.model.response;

import com.common.base.model.constant.ItachiStatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItachiResponse {

    private int status;
    private String message;
    private Object data;

    private long time = System.currentTimeMillis();

    public ItachiResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ItachiResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public ItachiResponse(ItachiStatusCode statusCode, Object data) {
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public ItachiResponse(ItachiStatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = null;
    }

}
