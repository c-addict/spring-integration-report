package org.example.config.channel.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.*;
import org.springframework.messaging.MessageChannel;

import java.util.concurrent.Executors;

@Configuration
public class ChannelConfiguration {

    @Bean
    public MessageChannel publishSubscribeChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public MessageChannel queueChannel() {
        return new QueueChannel();
    }

    @Bean
    public MessageChannel priorityChannel() {
        return new PriorityChannel();
    }

    @Bean
    public MessageChannel rendezvousChannel() {
        return new RendezvousChannel();
    }

    @Bean
    public MessageChannel directChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel executorChannel() {
        return new ExecutorChannel(Executors.newSingleThreadExecutor());
    }

    @Bean
    public MessageChannel fluxMessageChannel() {
        return new FluxMessageChannel();
    }
}
