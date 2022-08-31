package org.example.config.splitter.dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class SplitterDslConfiguration {

    @Bean
    public MessageChannel splitterInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow splitterConfiguration(MessageChannel splitterInputChannel) {
        return IntegrationFlows
                .from(splitterInputChannel)
                .split()
                .get();
    }
}
