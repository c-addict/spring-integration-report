package org.example.config.splitter.java;

import org.example.splitter.splitter.OrderSplitter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class SplitterConfiguration {

    @Bean
    public MessageChannel inputSplitterChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputSplitterChannel() {
        return new DirectChannel();
    }

    @Bean
    @Splitter(
            inputChannel = "inputSplitterChannel",
            outputChannel = "outputSplitterChannel"
    )
    public OrderSplitter orderSplitter() {
        return new OrderSplitter();
    }
}
