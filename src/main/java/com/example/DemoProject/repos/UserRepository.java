package com.example.DemoProject.repos;

import com.example.DemoProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserRepository> findByMail(String mail) ;
}
