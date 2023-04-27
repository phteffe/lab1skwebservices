package org.example.provider;

import org.example.service.CurrencyExchange;
public class EurConverter implements CurrencyExchange{
    @Override
    public double getCurrencyExchange() {
        return 11.39;
    }
}
