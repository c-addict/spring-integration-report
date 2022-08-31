package org.example.config.transformer.dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class TransformerDslConfiguration {
    @Bean
    public MessageChannel transformerInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow transformerFlow(MessageChannel transformerInputChannel) {
        return IntegrationFlows
                .from(transformerInputChannel)
                .<String, String>transform(String::toUpperCase)
                .get();

    }
}
