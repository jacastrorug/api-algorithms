package com.api.algorithms.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BaseResponse implements Serializable {

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "status")
    private int status;

    @JsonProperty(value = "success")
    private boolean success;

    public BaseResponse(String message) {
        this(message, 200);
    }

    public BaseResponse(String message, int status) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
