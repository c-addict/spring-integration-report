package org.example.config.channel.dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class ChannelDslConfiguration {

    @Bean
    public MessageChannel dslDirectChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel dslToDirectChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow integrationFlow(MessageChannel dslDirectChannel) {
        return IntegrationFlows.from(dslDirectChannel)
                .channel("dslToDirectChannel")
                .get();
    }
}
