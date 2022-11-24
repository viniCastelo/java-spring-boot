package com.udemy.javaspringboot.repositories;

import com.udemy.javaspringboot.entities.OrderItem;
import com.udemy.javaspringboot.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}