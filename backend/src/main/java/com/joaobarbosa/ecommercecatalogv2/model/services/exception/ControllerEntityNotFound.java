package com.joaobarbosa.ecommercecatalogv2.model.services.exception;

public class ControllerEntityNotFound extends RuntimeException {

    public ControllerEntityNotFound(String message) {
        super(message);
    }
}
