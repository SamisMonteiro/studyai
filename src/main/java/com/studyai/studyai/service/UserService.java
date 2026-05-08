package com.studyai.studyai.service;

import com.studyai.studyai.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.studyai.studyai.entity.User;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User salvarUsuario(User user) {
        return userRepository.save(user);
    }

    public List<User> listarUsuarios() {
        return userRepository.findAll();
    }
    public User buscarPorId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deletarUsuario(Long id) {
        userRepository.deleteById(id);
    }
}
