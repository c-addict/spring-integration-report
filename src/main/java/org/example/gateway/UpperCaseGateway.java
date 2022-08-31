package org.example.gateway;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(
        defaultRequestChannel = "inputGatewayChannel",
        defaultReplyChannel = "outputGatewayChannel"
)
public interface UpperCaseGateway {

    String upperCase(String str);
}
