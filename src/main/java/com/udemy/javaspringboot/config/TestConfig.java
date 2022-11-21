package com.udemy.javaspringboot.config;

import com.udemy.javaspringboot.entities.Order;
import com.udemy.javaspringboot.entities.User;
import com.udemy.javaspringboot.entities.enums.OrderStatus;
import com.udemy.javaspringboot.repositories.OrderRepository;
import com.udemy.javaspringboot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Vinícius", "vkstello@gmail.com", "(87) 99975-4035)", "123");
        User u2 = new User(null, "Karen", "karenbeamazing@gmail.com", "(11) 98462-9821)", "123");

        Order o1 = new Order(null, Instant.parse("2022-11-20T18:57:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
    }
}