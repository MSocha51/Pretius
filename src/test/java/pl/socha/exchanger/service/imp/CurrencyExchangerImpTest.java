package pl.socha.exchanger.service.imp;


import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.socha.exchanger.domain.CurrencyRate;
import pl.socha.exchanger.service.CurrencyExchanger;
import pl.socha.exchanger.service.CurrencyRates;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@SpringBootTest
public class CurrencyExchangerImpTest {

    private static CurrencyExchanger exchanger;

    @BeforeClass
    public static void setup() {
        exchanger = new CurrencyExchangerImp(new DummyRates());
    }

    @Test
    public void shouldNotChangeValueWhenSameCurrencies() {
        final BigDecimal value = BigDecimal.valueOf(1000).setScale(2);
        final BigDecimal exchangedValue = exchanger.exchangeCurrency(value, "CHF", "CHF");
        assertEquals("values after exchange should be equals", value, exchangedValue);
    }

    @Test
    public void shouldCorrectChangeValueFromPLNtoUSD() {
        final BigDecimal value = BigDecimal.valueOf(1000).setScale(2);
        final BigDecimal exchangedValue = exchanger.exchangeCurrency(value, "USD", "PLN");
        final BigDecimal expectedValue = BigDecimal.valueOf(2000).setScale(2);
        assertEquals("values after exchange should be equals", expectedValue, exchangedValue);
    }

    @Test
    public void shouldCorrectChangeValueFromUSDtoEUR() {
        final BigDecimal value = BigDecimal.valueOf(1000).setScale(2);
        final BigDecimal exchangedValue = exchanger.exchangeCurrency(value, "USD", "EUR");
        final BigDecimal expectedValue = BigDecimal.valueOf(66667, 2);
        assertEquals("values after exchange should be equals", expectedValue, exchangedValue);
    }

    @Test
    public void shouldCorrectChangeValueFromCHFtoPLN() {
        final BigDecimal value = BigDecimal.valueOf(1000).setScale(2);
        final BigDecimal exchangedValue = exchanger.exchangeCurrency(value, "CHF", "PLN");
        final BigDecimal expectedValue = BigDecimal.valueOf(233333, 2);
        assertEquals("values after exchange should be equals", expectedValue, exchangedValue);
    }


    private static class DummyRates implements CurrencyRates {

        private final CurrencyRate pln = new CurrencyRate("PLN", BigDecimal.valueOf(1));
        private final CurrencyRate usd = new CurrencyRate("USD", BigDecimal.valueOf(2));
        private final CurrencyRate eur = new CurrencyRate("EUR", BigDecimal.valueOf(3));
        private final CurrencyRate chf = new CurrencyRate("CHF", BigDecimal.valueOf(2333333, 6));

        @Override
        public CurrencyRate getCurrency(final String code) {
            switch (code) {
                case "USD":
                    return usd;
                case "EUR":
                    return eur;
                case "PLN":
                    return pln;
                default:
                    return chf;
            }
        }
    }
}

