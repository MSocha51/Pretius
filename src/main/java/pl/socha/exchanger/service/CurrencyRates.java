package pl.socha.exchanger.service;

import pl.socha.exchanger.domain.CurrencyRate;

public interface CurrencyRates {
    public CurrencyRate getCurrency(String code);

    }
