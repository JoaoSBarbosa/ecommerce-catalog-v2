package com.joaobarbosa.ecommercecatalogv2.utils.model;

import org.springframework.web.bind.annotation.ControllerAdvice;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;


public class StanderError implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String message;
    private Integer status;
    private Instant timestamp;
    private String error;
    private String path;
    public StanderError() {}

    public StanderError(String message, Integer status, Instant timestamp, String error, String path) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}