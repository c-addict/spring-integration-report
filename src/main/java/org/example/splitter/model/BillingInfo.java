package org.example.splitter.model;

import lombok.Data;

@Data
public class BillingInfo {

    private final String cardNumber;

    private final String cardData;

    private final String cardCVV;
}
