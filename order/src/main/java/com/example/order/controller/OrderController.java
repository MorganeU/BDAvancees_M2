package com.example.order.controller;

import com.example.order.Order;
import com.example.order.OrderItem;
import com.example.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    //@Autowired
    //CartItemRepository cartItemRepository;

    @PostMapping(value = "/order")
    public ResponseEntity<Order> createNewOrder(@RequestBody Order orderData)
    {
        Order order = orderRepository.save(new Order());

        if (order == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Couldn't create a new order");
        }

        return new ResponseEntity<Order>(order , CREATED);
    }

    @GetMapping(value = "order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id)
    {
        Optional<Order> order = orderRepository.findById(id);
        if (!order.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Couldn't get order");
        }
        return new ResponseEntity<Order>(order.get(), HttpStatus.CREATED);
    }
}
