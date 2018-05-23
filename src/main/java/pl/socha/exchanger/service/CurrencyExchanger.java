package pl.socha.exchanger.service;

import java.math.BigDecimal;

public interface CurrencyExchanger {

    BigDecimal exchangeCurrency(BigDecimal value, String from, String to);
}
