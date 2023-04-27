package org.example.provider;

import org.example.service.CurrencyExchange;

public class SterlingConverter implements CurrencyExchange{
    @Override
    public double getCurrencyExchange() {
        return 12.86;
    }
}
