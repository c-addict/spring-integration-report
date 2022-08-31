package org.example.config.router.dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class RouterDslConfiguration {

    @Bean
    public MessageChannel routerInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow numberRoutingFlow(MessageChannel routerInputChannel) {
        return IntegrationFlows
                .from(routerInputChannel)
				.<Integer, String>route(n -> n % 2 == 0 ? "EVEN" : "ODD", mapping -> mapping
                .subFlowMapping("EVEN", sf -> sf
                        .<Integer, Integer>transform(n -> n * 10)
                        .handle((i, h) -> {})
                )
                .subFlowMapping("ODD", sf -> sf
                        .transform(...)
						.handle((i, h) -> {})
					)
				)
			.get();
    }
}
