package com.order.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class PartnerResponse {

    private int status;
    private String message;
    private Object data;

    private long time = System.currentTimeMillis();

    public PartnerResponse(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public PartnerResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.data = null;
    }

    public PartnerResponse(PartnerStatusCode statusCode, Object data) {
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public PartnerResponse(PartnerStatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.message = statusCode.getMessage();
        this.data = null;
    }

}
