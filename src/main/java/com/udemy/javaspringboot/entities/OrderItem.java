package com.udemy.javaspringboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.udemy.javaspringboot.entities.pk.OrderItemPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tbl_order_item")
public class OrderItem implements Serializable {

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();
    private Integer quantity;
    private Double price;

    public OrderItem(){}

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        id.setProduct(product);
        id.setOrder(order);
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    @JsonIgnore
    public Order getOrder(){
        return id.getOrder();
    }

    public Product getProduct(){
        return id.getProduct();
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrder (Order order){
        id.setOrder(order);
    }

    public void setProduct (Product product){
        id.setProduct(product);
    }

    public Double getSubTotal(){
        return getPrice() * getQuantity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}