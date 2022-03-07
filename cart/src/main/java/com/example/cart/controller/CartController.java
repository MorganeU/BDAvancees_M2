package com.example.cart.controller;

import com.example.cart.Cart;
import com.example.cart.CartItem;
import com.example.cart.repository.CartItemRepository;
import com.example.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
public class CartController {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;

    @PostMapping(value = "/cart")
    public ResponseEntity<Cart> createNewCart(@RequestBody Cart cartData)
    {
        Cart cart = cartRepository.save(new Cart());

        if (cart == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new cart");
        }

        return new ResponseEntity<Cart>(cart , CREATED);
    }

    @GetMapping(value = "cart/{id}")
    public Optional<Cart> getCart(@PathVariable Long id)
    {
        Optional<Cart> cart = cartRepository.findById(id);
        if (!cart.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get cart");
        }
        return cart;
    }

    @PostMapping(value = "cart/{id}")
    @Transactional
    public ResponseEntity<CartItem> addProductToCart(@PathVariable Long id, @RequestBody CartItem cartItem)
    {
        Cart cart = cartRepository.getOne(id);
        if (cart == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get cart");
        }
        cart.addProduct(cartItem);
        cartRepository.save(cart);
        return new ResponseEntity<CartItem>(cartItem, HttpStatus.CREATED);
    }

}
