package com.studyai.studyai.repository;

import com.studyai.studyai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);

    Optional<User> findByCpf(String cpf);

}
