package br.com.fiap.msusuario.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    ResponseEntity<StandardError> handleWrongCredentials(BadCredentialsException e, HttpServletRequest request) {
        StandardError error = StandardError.builder()
                .timestamp(Instant.now())
                .status(401)
                .error("Username or password are incorrect")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(404).body(error);
    }
}
