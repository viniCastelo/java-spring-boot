package com.udemy.javaspringboot.repositories;

import com.udemy.javaspringboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}