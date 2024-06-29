package br.com.fiap.msusuario.domain.service.implementations;

import br.com.fiap.msusuario.application.controller.request.LoginRequest;
import br.com.fiap.msusuario.application.controller.request.UserRequest;
import br.com.fiap.msusuario.application.controller.response.LoginResponse;
import br.com.fiap.msusuario.application.controller.response.UserReponse;
import br.com.fiap.msusuario.domain.entity.User;
import br.com.fiap.msusuario.domain.mapper.UserMapper;
import br.com.fiap.msusuario.domain.security.authentication.TokenService;
import br.com.fiap.msusuario.domain.security.userdetails.UserDetailsImpl;
import br.com.fiap.msusuario.domain.service.UserService;
import br.com.fiap.msusuario.infrastructure.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final TokenService tokenService;

    public UserServiceImpl(AuthenticationManager authenticationManager, UserRepository repository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.repository = repository;
        this.tokenService = tokenService;
    }

    @Override
    public UserReponse registerUser(UserRequest userRequest) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(userRequest.password());
        User newUser = new User(userRequest.login(), encryptedPassword, userRequest.role());

        return UserMapper.userToUserReponse(repository.save(newUser));
    }

    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        Authentication usernamePassword = new UsernamePasswordAuthenticationToken(loginRequest.login(), loginRequest.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        return new LoginResponse(tokenService.generateToken((UserDetailsImpl) auth.getPrincipal()));
    }
}
