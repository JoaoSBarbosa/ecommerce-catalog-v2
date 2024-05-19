package com.joaobarbosa.ecommercecatalogv2.controllers.exception;

import com.joaobarbosa.ecommercecatalogv2.model.services.exception.ControllerEntityNotFound;
import com.joaobarbosa.ecommercecatalogv2.utils.model.StanderError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ControllerEntityNotFound.class)
    public ResponseEntity<StanderError> entityNotFound(ControllerEntityNotFound exception, HttpServletRequest request) {
        StanderError standerError = new StanderError();

        standerError.setMessage(exception.getMessage());
        standerError.setError("recurso não encontrado! 🤔🤷‍♂️");
        standerError.setPath(request.getRequestURI());
        standerError.setTimestamp(Instant.now());
        standerError.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(standerError);
    }
}
