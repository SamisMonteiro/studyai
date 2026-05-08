package com.studyai.studyai.controller;

import com.studyai.studyai.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.studyai.studyai.entity.User;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User salvarUsuario(@RequestBody User user) {
        return userService.salvarUsuario(user);
    }

    @GetMapping
    public List<User> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public User buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
    }

}
