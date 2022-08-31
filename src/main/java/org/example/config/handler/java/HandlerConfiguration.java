package org.example.config.handler.java;

import lombok.extern.slf4j.Slf4j;
import org.example.repositories.OrderRepository;
import org.example.splitter.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Slf4j
@Configuration
public class HandlerConfiguration {

    @Bean
    public MessageChannel logHandlerInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel orderHandlerInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel orderHandlerOutputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "logHandlerInputChannel")
    public MessageHandler logHandler() {
        return message -> log.info("Message: {}", message.getPayload());
    }

    @Bean
    @ServiceActivator(
            inputChannel = "orderHandlerInputChannel",
            outputChannel = "orderHandlerOutputChannel"
    )
    public GenericHandler<Order> orderHandler(OrderRepository repository) {
        return ((payload, headers) -> repository.save(payload));
    }
}
