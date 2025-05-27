package com.example.Shipment.Order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Shipment.Order.dto.OrderDto;
import com.example.Shipment.Order.dto.Response;
import com.example.Shipment.Order.entity.Orders;
import com.example.Shipment.Order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Orders order) {
        try {
            OrderDto newOrder = orderService.createOrder(order);
            System.out.println("newOrder: " + newOrder);
            return new ResponseEntity<>(new Response("success", "new order created with details: " + newOrder), HttpStatus.CREATED);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<?> getOrdersByEmail(@PathVariable String email) {
        try {
            List<Orders> orders = orderService.getOrdersByEmail(email);
            if (orders.isEmpty()) {
                return new ResponseEntity<>(new Response("success", "No orders found for email: " + email), HttpStatus.OK);
            }
            return new ResponseEntity<>(orders, HttpStatus.OK);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<>(new Response("error", ex.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
