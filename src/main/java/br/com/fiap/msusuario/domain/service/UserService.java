package br.com.fiap.msusuario.domain.service;

import br.com.fiap.msusuario.application.controller.request.UserAuthRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.UserResponse;

public interface UserService {
    UserResponse registerUser(UserRequest userRequest);

    String authenticateUser(UserAuthRequest loginRequest);
}
