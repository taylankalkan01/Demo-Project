package com.example.DemoProject;

import com.example.DemoProject.model.User;
import com.example.DemoProject.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectApplication implements CommandLineRunner {
    private final UserRepository userRepository;

    public DemoProjectApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.save(new User(null,
                "deneme@gmail.com",
                "eren",
                "kalkan",
                "taylan"));

        userRepository.save(new User(null,
                "d@gmail.com",
                "e",
                "k",
                "t"));

        userRepository.save(new User(null,
                "den@gmail.com",
                "er",
                "kal",
                "tay"));

    }

}
