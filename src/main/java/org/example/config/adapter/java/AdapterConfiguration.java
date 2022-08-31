package org.example.config.adapter.java;

import org.example.splitter.model.BillingInfo;
import org.example.splitter.model.Order;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AdapterConfiguration {

    @Bean
    public AtomicInteger source() {
        return new AtomicInteger();
    }

    @Bean
    @InboundChannelAdapter(
            poller = @Poller(fixedRate = "1000"),
            channel = "inputAdapterChannel"
    )
    public MessageSource<Order> numberSource() {
        return () -> new GenericMessage<>(
                new Order(
                        new BillingInfo(
                                "",
                                "",
                                ""
                        )
                )
        );
    }
}
