package org.example.config.handler.dsl;

import lombok.extern.slf4j.Slf4j;
import org.example.repositories.OrderRepository;
import org.example.splitter.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Slf4j
@Configuration
public class HandlerDslConfiguration {

    @Bean
    public MessageChannel inputLogHandlerFlowChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow logHandlerFlow(MessageChannel inputLogHandlerFlowChannel) {
        return IntegrationFlows
                .from(inputLogHandlerFlowChannel)
                .handle(msg -> log.info("Message: {}", msg.getPayload()))
                .get();
    }

    @Bean
    public IntegrationFlow saveHandlerFlow(OrderRepository repository) {
        return IntegrationFlows
                .from(inputLogHandlerFlowChannel())
                .<Order>handle((payload, headers) -> repository.save(payload))
                .get();
    }
}
