package org.example.config.transformer.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.transformer.GenericTransformer;
import org.springframework.messaging.MessageChannel;

@Configuration
public class TransformerConfiguration {

    @Bean
    public MessageChannel stringChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel upperCaseStringChannel() {
        return new DirectChannel();
    }

    @Transformer(
            inputChannel = "stringChannel",
            outputChannel = "upperCaseStringChannel"
    )
    public GenericTransformer<String, String> upperCaseTransformer() {
        return String::toUpperCase;
    }
}
