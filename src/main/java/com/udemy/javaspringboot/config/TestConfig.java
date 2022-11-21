package com.udemy.javaspringboot.config;

import com.udemy.javaspringboot.entities.Category;
import com.udemy.javaspringboot.entities.Order;
import com.udemy.javaspringboot.entities.Product;
import com.udemy.javaspringboot.entities.User;
import com.udemy.javaspringboot.entities.enums.OrderStatus;
import com.udemy.javaspringboot.repositories.CategoryRepository;
import com.udemy.javaspringboot.repositories.OrderRepository;
import com.udemy.javaspringboot.repositories.ProductRepository;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Vinícius", "vkstello@gmail.com", "(87) 99975-4035)", "123");
        User u2 = new User(null, "Karen", "karenbeamazing@gmail.com", "(11) 98462-9821)", "123");

        Order o1 = new Order(null, Instant.parse("2022-11-20T18:57:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2022-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2022-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category ctg1 = new Category(null, "Electronics");
        Category ctg2 = new Category(null, "Books");
        Category ctg3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));
        categoryRepository.saveAll(Arrays.asList(ctg1,ctg2,ctg3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(ctg2);
        p2.getCategories().add(ctg1);
        p2.getCategories().add(ctg3);
        p3.getCategories().add(ctg3);
        p4.getCategories().add(ctg3);
        p5.getCategories().add(ctg2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

    }
}