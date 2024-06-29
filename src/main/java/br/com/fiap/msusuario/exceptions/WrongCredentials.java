package br.com.fiap.msusuario.exceptions;

public class WrongCredentials extends RuntimeException {
    public WrongCredentials(String message) {
        super(message);
    }

    public WrongCredentials(String message, Throwable cause) {
        super(message, cause);
    }
}
