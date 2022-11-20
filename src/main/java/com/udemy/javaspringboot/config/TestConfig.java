package com.udemy.javaspringboot.config;

import com.udemy.javaspringboot.entities.User;
import com.udemy.javaspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Vinícius", "vkstello@gmail.com", "(87) 99975-4035)", "123");
        User u2 = new User(null, "Karen", "karenbeamazing@gmail.com", "(11) 98462-9821)", "123");
        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}