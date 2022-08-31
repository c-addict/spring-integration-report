package org.example.config.gateway.dsl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@Configuration
public class GatewayDslConfiguration {

    @Bean
    public IntegrationFlow gatewayFlow() {
        return IntegrationFlows
                .from("inputChannel")
                .<String, String>transform(s -> s.toUpperCase())
                .channel("outputChannel")
                .get();
    }
}
