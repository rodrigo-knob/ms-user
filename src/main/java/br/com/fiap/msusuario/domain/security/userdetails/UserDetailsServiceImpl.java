package br.com.fiap.msusuario.domain.security.userdetails;

import br.com.fiap.msusuario.domain.entity.User;
import br.com.fiap.msusuario.exceptions.WrongCredentials;
import br.com.fiap.msusuario.infrastructure.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = repository.findByLogin(username).orElseThrow(() -> new WrongCredentials("Login or password incorrect"));
        return new UserDetailsImpl(user);
    }
}
