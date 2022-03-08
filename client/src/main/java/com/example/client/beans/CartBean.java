package com.example.client.beans;

import java.util.List;

public class CartBean {
    private Long id;
    private List<CartItemBean> products;

    public CartBean(List<CartItemBean> products) {
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItemBean> getProducts() {
        return products;
    }

    public void setProducts(List<CartItemBean> products) {
        this.products = products;
    }
}
