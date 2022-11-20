package com.udemy.javaspringboot.resources;

import com.udemy.javaspringboot.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Vinícius", "vkstello@gmail.com", "(87) 9 9975-4035", "Colore@+1011");
        return ResponseEntity.ok().body(u);
    }

}