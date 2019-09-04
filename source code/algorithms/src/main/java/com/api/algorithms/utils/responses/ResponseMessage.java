package com.api.algorithms.utils.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ResponseMessage implements Serializable {

    private static final long serialVersionUID = 4963501839141296850L;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "status")
    private int status;

    @JsonProperty(value = "success")
    private boolean success;


    public ResponseMessage(String message, int status, boolean success) {
        this.message = message;
        this.status = status;
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
