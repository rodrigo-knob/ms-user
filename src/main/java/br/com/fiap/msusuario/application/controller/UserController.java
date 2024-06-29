package br.com.fiap.msusuario.application.controller;

import br.com.fiap.msusuario.application.controller.request.UserAuthRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.UserResponse;
import br.com.fiap.msusuario.domain.entity.User;
import br.com.fiap.msusuario.domain.security.authentication.TokenService;
import br.com.fiap.msusuario.domain.security.userdetails.UserDetailsImpl;
import br.com.fiap.msusuario.infrastructure.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    public UserController(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody UserAuthRequest data) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((UserDetailsImpl) auth.getPrincipal());

        return ResponseEntity.ok(new UserResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody UserRequest data) {
        if (repository.findByLogin(data.login()).isPresent()) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());

        repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
