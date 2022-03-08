package com.example.order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Entity
public class Order  {
    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> products;
    private int paidTotal;
    private int numberTotalOfProducts;
    private Date paidDate;

    public Order(){
        int max = 234543;
        Random random = new Random();
        long id = random.nextLong()*(max);
        this.id = id;
        this.products = new ArrayList<>();
        this.paidDate= new Date();
    }

    public Order(Long id, List<OrderItem> products, int paidTotal, int numberOfProducts, Date paidDate) {
        this.id = id;
        this.products = products;
        this.paidTotal = paidTotal;
        this.numberTotalOfProducts = numberOfProducts;
        this.paidDate = paidDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItem> products) {
        this.products = products;
    }

    public int getPaidTotal() {
        return paidTotal;
    }

    public void setPaidTotal(int paidTotal) {
        this.paidTotal = paidTotal;
    }

    public int getNumberTotalOfProducts() {
        return numberTotalOfProducts;
    }

    public void setNumberTotalOfProducts(int numberOfProducts) {
        this.numberTotalOfProducts = numberOfProducts;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public void addProduct(OrderItem orderItem) {
        products.add(orderItem);
    }
}
