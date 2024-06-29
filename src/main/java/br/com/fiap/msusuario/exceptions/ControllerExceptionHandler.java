package br.com.fiap.msusuario.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(WrongCredentials.class)
    ResponseEntity<StandardError> handleWrongCredentials(WrongCredentials e, HttpServletRequest request) {
        StandardError error = StandardError.builder()
                .status(404)
                .error("Incorrect credentials")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();
        return ResponseEntity.status(404).body(error);
    }
}
