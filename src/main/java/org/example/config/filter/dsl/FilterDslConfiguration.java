package org.example.config.filter.dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

@Configuration
public class FilterDslConfiguration {

    @Bean
    public MessageChannel inputNumberChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow evenNumberFlow(MessageChannel inputNumberChannel) {
        return IntegrationFlows
                .from(inputNumberChannel)
                .<Integer>filter(p -> p % 2 == 0)
                .get();
    }
}
