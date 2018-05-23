package pl.socha.exchanger.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.socha.exchanger.domain.CurrencyRate;
import pl.socha.exchanger.exception.CurrencyUnknownException;
import pl.socha.exchanger.service.CurrencyExchanger;
import pl.socha.exchanger.service.CurrencyRates;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import static java.math.RoundingMode.HALF_UP;
import static java.util.Objects.isNull;

@Service
public class CurrencyExchangerImp implements CurrencyExchanger {

    private CurrencyRates rates;

    @Autowired
    public CurrencyExchangerImp(CurrencyRates rates) {
        this.rates = rates;
    }

    @Override
    public BigDecimal exchangeCurrency(BigDecimal value, String from, String to) {

        if (from.equalsIgnoreCase(to)) return value.setScale(2);

        final CurrencyRate fromCurrency = rates.getCurrency(from);
        final CurrencyRate toCurrency = rates.getCurrency(to);
        if(isNull(fromCurrency) || isNull(toCurrency))
            throw new CurrencyUnknownException("Unknown currency, please check if NBP have these currenscies exchange rates");
        final BigDecimal fromMid = fromCurrency.getMid();
        final BigDecimal toMid = toCurrency.getMid();
        final BigDecimal result = value.multiply(fromMid).divide(toMid, HALF_UP);

        return result.setScale(2, HALF_UP);

    }
}

