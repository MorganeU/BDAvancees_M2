package com.example.cart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> products;

    public Cart() {
        int max = 234543;
        Random random = new Random();
        long id = random.nextLong()*(max);
        this.id = id;
        this.products = new ArrayList<>();
    }

    public Cart(Long id, List<CartItem> products) {
        this.id = id;
        this.products = products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setProducts(List<CartItem> products) {
        this.products = products;
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void addProduct(CartItem cartItem) {
        products.add(cartItem);
    }
}
