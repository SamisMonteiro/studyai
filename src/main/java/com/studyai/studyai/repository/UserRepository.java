package com.studyai.studyai.repository;

import com.studyai.studyai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long>{

}
