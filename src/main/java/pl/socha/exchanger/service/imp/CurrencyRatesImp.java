package pl.socha.exchanger.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.socha.exchanger.domain.CurrencyRate;
import pl.socha.exchanger.nbpconnect.NbpConnector;
import pl.socha.exchanger.service.CurrencyRates;
import java.util.Map;


@Service
public class CurrencyRatesImp implements CurrencyRates {

    private Map<String, CurrencyRate> currencies;
    private NbpConnector connector;

    @Autowired
    public CurrencyRatesImp(NbpConnector connector) {
        this.connector = connector;
        updateCurrencyRates();
    }

    public CurrencyRate getCurrency(String code) {
        return currencies.get(code);
    }

    @Scheduled(cron = "0 0 8 * * ?")
    public void updateCurrencyRates() {
       currencies = connector.getCurrenciesRatFromNbp();
    }



}