package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cart_id")
    public Integer id;
    @Column(name="created_date")
    public String createdDate;
    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    public Payment payment;
    @Column(name = "name")
    public String name;

    @OneToMany(mappedBy = "cart")
    @JsonIgnore
    public List<Order> orders;

    @ManyToOne
    public Customer customer;

    public Cart(String createdDate, Payment payment, List<Order> orders, Customer customer) {
        this.createdDate = createdDate;
        this.payment = payment;
        this.orders = orders;
        this.customer = customer;
    }

    public Cart() {}

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() { return this.name; }

    public void setName(String name) { this.name = name; }
}
