package br.com.fiap.msusuario.domain.service.implementations;

import br.com.fiap.msusuario.application.controller.request.UserAuthRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.UserResponse;
import br.com.fiap.msusuario.domain.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public UserResponse registerUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public String authenticateUser(UserAuthRequest loginRequest) {
        return null;
    }
}
