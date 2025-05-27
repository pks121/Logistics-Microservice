package com.example.Shipment.Order.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import com.example.Shipment.Order.dto.OrderDto;
import com.example.Shipment.Order.entity.Orders;
import com.example.Shipment.Order.repo.OrderRepository;

@Service
public class OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private static final String MESSAGING_DESTINATION = "email-out-0";

    private final StreamBridge streamBridge;
    private final OrderRepository orderRepository;

    public OrderService(StreamBridge streamBridge, OrderRepository orderRepository) {
        this.streamBridge = streamBridge;
        this.orderRepository = orderRepository;
    }

    public OrderDto createOrder(Orders order) {
        validateOrder(order);

        order.setCreatedAt(LocalDateTime.now());
        order.setStatus("PENDING");

        Orders createdOrder = orderRepository.save(order);
        OrderDto orderDto = new OrderDto(
                createdOrder.getCreatedAt(),
                createdOrder.getStatus(),
                createdOrder.getDestination(),
                createdOrder.getWeight()
        );

        sendCommunication(orderDto);
        return orderDto;
    }

    private void validateOrder(Orders order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getWeight() <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        if (order.getHeight() <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        if (order.getLength() <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (order.getWidth() <= 0) {
            throw new IllegalArgumentException("Width must be greater than 0");
        }
    }

    private void sendCommunication(OrderDto order) {
        try {
            log.debug("Sending message to: {}", MESSAGING_DESTINATION);
            log.debug("Message content: {}", order);
            boolean result = streamBridge.send(MESSAGING_DESTINATION, order);
            log.debug("Message send result: {}", result);
        } catch (Exception e) {
            log.error("Error sending message: {}", e.getMessage(), e);
        }
    }

    public List<Orders> getOrdersByEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        return orderRepository.findByEmail(email);
    }
}
