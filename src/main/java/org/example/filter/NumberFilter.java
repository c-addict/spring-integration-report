package org.example.filter;

import org.springframework.integration.annotation.Filter;
import org.springframework.stereotype.Component;

@Component
public class NumberFilter {

    @Filter(
            inputChannel = "numberChannel",
            outputChannel = "oddNumberChannel"
    )
    public boolean isOdd(Integer number) {
        return number % 2 == 1;
    }

    @Filter(
            inputChannel = "numberChannel",
            outputChannel = "evenNumberChannel"
    )
    public boolean isEven(Integer number) {
        return number % 2 == 0;
    }
}
