package br.com.fiap.msusuario.controller;

import br.com.fiap.msusuario.entity.User;
import br.com.fiap.msusuario.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {this.repository = repository;}

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.repository.findAll();

        return ResponseEntity.ok(users);
    }

}
