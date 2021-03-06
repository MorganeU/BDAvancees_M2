package com.example.client.controller;

import com.example.client.beans.CartItemBean;
import com.example.client.beans.ProductBean;
import com.example.client.proxy.MsCartProxy;
import com.example.client.proxy.MsProductProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {

    @Autowired
    private MsProductProxy msProductProxy;

    @Autowired
    private MsCartProxy msCartProxy;

    @RequestMapping("/")
    public String index(Model model) {
        List<ProductBean> products = msProductProxy.list();
        System.out.println(products);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/product-detail/{id}")
    public String getProductDetails(@PathVariable Long id, Model model)
    {
        Optional<ProductBean> productDetail = msProductProxy.get(id);
        if (!productDetail.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get product details");
        }
        model.addAttribute("product",productDetail.get());
        return "product-detail";
    }

    @PostMapping(value ="/addProduct/{itemId}/{quantity}")
    public void addItem(@PathVariable Long itemId, @PathVariable Integer quantity) {
        CartItemBean newItem = new CartItemBean(itemId, quantity);
        msCartProxy.addProductToCart((long) 0, newItem);  // temporairement on utilise un id de 0
    }
}
