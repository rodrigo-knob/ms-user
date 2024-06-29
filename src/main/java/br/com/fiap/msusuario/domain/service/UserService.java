package br.com.fiap.msusuario.domain.service;

import br.com.fiap.msusuario.application.controller.request.LoginRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.LoginResponse;
import br.com.fiap.msusuario.application.controller.response.UserReponse;

public interface UserService {
    UserReponse registerUser(UserRequest userRequest);

    LoginResponse authenticateUser(LoginRequest loginRequest);
}
