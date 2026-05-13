package com.studyai.studyai.controller;

import com.studyai.studyai.dto.UserResponseDTO;
import com.studyai.studyai.service.UserService;
import jakarta.validation.Valid;
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
    public UserResponseDTO salvarUsuario(@Valid @RequestBody User user) {
        return userService.salvarUsuario(user);
    }

    @GetMapping
    public List<UserResponseDTO> listarUsuarios() {
        return userService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UserResponseDTO buscarPorId(@PathVariable Long id) {
        return userService.buscarPorId(id);
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
    }
    @PutMapping("/{id}")
    public UserResponseDTO atualizarUsuario(@PathVariable Long id, @Valid @RequestBody User userAtualizado) {
        return userService.atualizarUsuario(id, userAtualizado);

    }

}
