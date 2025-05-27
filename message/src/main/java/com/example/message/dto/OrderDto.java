package com.example.message.dto;

import java.time.LocalDateTime;


public class OrderDto{

    private LocalDateTime createdAt;

    private String status;

    private String destination;

    private double weight;

    public OrderDto() {
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "createdAt=" + createdAt +
                ", status='" + status + '\'' +
                ", destination='" + destination + '\'' +
                ", weight=" + weight +
                '}';
    }

    public OrderDto(LocalDateTime createdAt, String status, String destination, double weight) {
        this.createdAt = createdAt;
        this.status = status;
        this.destination = destination;
        this.weight = weight;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
