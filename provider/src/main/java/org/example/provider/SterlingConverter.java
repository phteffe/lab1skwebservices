package org.example.provider;

import org.example.service.CurrencyExchange;
import org.example.service.annotation.Currency;

@Currency("GBP")
public class SterlingConverter implements CurrencyExchange{
    @Override
    public double getCurrency(double amount) {
        return amount * 0.08;
    }
}
