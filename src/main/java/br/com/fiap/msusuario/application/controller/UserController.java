package br.com.fiap.msusuario.application.controller;

import br.com.fiap.msusuario.application.controller.request.LoginRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.LoginResponse;
import br.com.fiap.msusuario.application.controller.response.UserReponse;
import br.com.fiap.msusuario.application.documentation.UserControllerDoc;
import br.com.fiap.msusuario.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController implements UserControllerDoc {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.authenticateUser(loginRequest));
    }

    @PostMapping("/register")
    public ResponseEntity<UserReponse> register(@Valid @RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userService.registerUser(userRequest));
    }
}
