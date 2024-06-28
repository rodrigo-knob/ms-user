package br.com.fiap.msusuario.request;


import br.com.fiap.msusuario.entity.enums.UserRole;

public record UserRequest(String login, String password, UserRole role) {
}
