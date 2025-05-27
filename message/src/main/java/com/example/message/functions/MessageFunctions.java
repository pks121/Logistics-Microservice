package com.example.message.functions;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.message.dto.OrderDto;

@Configuration
public class MessageFunctions {

    private static final Logger log = LoggerFactory.getLogger(MessageFunctions.class);

    @Bean
    public Function<OrderDto, OrderDto> email() {
        log.info("Email function bean initialized");
        return orderDto -> {
            log.info("Processing email for order: {}", orderDto);
            return orderDto;
        };
    }

    @Bean
    public Function<OrderDto, String> sms() {
        log.info("SMS function bean initialized");
        return orderDto -> {
            log.info("Processing SMS for order: {}", orderDto);
            return orderDto.getDestination();
        };
    }

}
