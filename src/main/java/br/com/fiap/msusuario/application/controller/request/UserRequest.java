package br.com.fiap.msusuario.application.controller.request;


import br.com.fiap.msusuario.domain.entity.enums.UserRole;

public record UserRequest(String login, String password, UserRole role) {
}
