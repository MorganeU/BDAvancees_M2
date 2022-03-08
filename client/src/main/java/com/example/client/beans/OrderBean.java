package com.example.client.beans;

import java.util.Date;
import java.util.List;

public class OrderBean {
    private Long id;
    private List<OrderItemBean> products;
    private int paidTotal;
    private int numberTotalOfProducts;
    private Date paidDate;

    public OrderBean(Long id, List<OrderItemBean> products, int paidTotal, int numberTotalOfProducts, Date paidDate) {
        this.id = id;
        this.products = products;
        this.paidTotal = paidTotal;
        this.numberTotalOfProducts = numberTotalOfProducts;
        this.paidDate = paidDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItemBean> getProducts() {
        return products;
    }

    public void setProducts(List<OrderItemBean> products) {
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

    public void setNumberTotalOfProducts(int numberTotalOfProducts) {
        this.numberTotalOfProducts = numberTotalOfProducts;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
}
