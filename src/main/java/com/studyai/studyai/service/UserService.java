package com.studyai.studyai.service;

import com.studyai.studyai.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.studyai.studyai.entity.User;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User salvarUsuario(User user) {
        return userRepository.save(user);
    }

}
