package pl.socha.exchanger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.socha.exchanger.controller.dto.CurrencyExchangeRequest;
import pl.socha.exchanger.controller.dto.CurrencyExchangeResponse;
import pl.socha.exchanger.controller.exception.CurrencyExchangeException;
import pl.socha.exchanger.service.CurrencyExchanger;

import java.math.BigDecimal;

import static org.apache.commons.lang3.StringUtils.isAnyBlank;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.math.NumberUtils.isParsable;

@RestController
public class CurrencyExchangeRestController {

    private CurrencyExchanger exchanger;

    @Autowired
    public CurrencyExchangeRestController(CurrencyExchanger exchanger) {
        this.exchanger = exchanger;
    }

    @PostMapping("/exchange")
    public CurrencyExchangeResponse exchangeCurrency(@RequestBody CurrencyExchangeRequest request) {
        check(request);
        final String currency = request.getCurrency().toUpperCase();
        final String targetCurrency = request.getTargerCurrency().toUpperCase();
        final String value = request.getValue();

        final BigDecimal exchangedValue = exchanger.exchangeCurrency(new BigDecimal(value), currency, targetCurrency);
        return CurrencyExchangeResponse.builder()
                .value(exchangedValue.toString())
                .currency(targetCurrency)
                .previousValue(value)
                .previousCurrency(currency)
                .build();

    }

    private void check(CurrencyExchangeRequest request){
        final String currency = request.getCurrency();
        final String targetCurrency = request.getTargerCurrency();
        final String value = request.getValue();
        if (isAnyBlank(currency ,targetCurrency))
            throw new CurrencyExchangeException("Currency code cannot be empty");
        else if(isBlank(value) || !isParsable(value))
            throw new CurrencyExchangeException("Currency value must be valid number");
    }
}
