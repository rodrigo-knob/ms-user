package br.com.fiap.msusuario.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Getter
@SuperBuilder
@NoArgsConstructor
public class StandardError {
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
