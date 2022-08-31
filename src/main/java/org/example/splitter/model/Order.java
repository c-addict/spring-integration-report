package org.example.splitter.model;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class Order {

    private final BillingInfo billingInfo;

    private final List<Product> products = new LinkedList<>();
}
