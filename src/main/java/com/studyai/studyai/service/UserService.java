package com.studyai.studyai.service;

import com.studyai.studyai.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.studyai.studyai.entity.User;

import java.util.List;

import com.studyai.studyai.dto.UserResponseDTO;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User salvarUsuario(User user) {
        return userRepository.save(user);
    }

    public List<UserResponseDTO> listarUsuarios() {
        return userRepository.findAll().stream().map(this::converterParaDTO).toList();
    }

    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }

    public User atualizarUsuario(Long id, User userAtualizado) {
        User usuarioExistente = buscarPorId(id);
        usuarioExistente.setNome(userAtualizado.getNome());
        usuarioExistente.setEmail(userAtualizado.getEmail());
        usuarioExistente.setCpf(userAtualizado.getCpf());
        usuarioExistente.setSenha(userAtualizado.getSenha());
        return userRepository.save(usuarioExistente);

    }

    private UserResponseDTO converterParaDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setNome(user.getNome());
        dto.setEmail(user.getEmail());
        dto.setCpf(user.getCpf());
        return dto;
    }
}
