package com.example.order;

import com.example.order.beans.CartItemBean;
import java.util.Date;
import java.util.List;

public class Order  {
    private Long id;
    private List<CartItemBean> products;
    private int paidTotal;
    private int numberTotalOfProducts;
    private Date paidDate;

    public Order(){}

    public Order(Long id, List<CartItemBean> products, int paidTotal, int numberOfProducts, Date paidDate) {
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

    public List<CartItemBean> getProducts() {
        return products;
    }

    public void setProducts(List<CartItemBean> products) {
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
}
