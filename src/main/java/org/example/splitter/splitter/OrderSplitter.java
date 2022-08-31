package org.example.splitter.splitter;

import org.example.splitter.model.Order;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class OrderSplitter {

    public Collection<Object> splitOrder(Order order) {
        List<Object> parts = new ArrayList<>();
        parts.add(order.getBillingInfo());
        parts.add(order.getProducts());
        return parts;
    }
}
