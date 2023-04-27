package org.example.provider;

import org.example.service.CurrencyExchange;
public class DollarConverter implements CurrencyExchange{
    @Override
    public double getCurrencyExchange() {
        return 10.31;
    }
}
