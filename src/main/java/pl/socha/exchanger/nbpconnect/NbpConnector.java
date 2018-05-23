package pl.socha.exchanger.nbpconnect;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.socha.exchanger.domain.CurrencyRate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

@Component
public class NbpConnector {
    public Map<String, CurrencyRate> getCurrenciesRatFromNbp() {
        final RestTemplate restTemplate = new RestTemplate();
        final RequestEntity<Void> requestA = RequestEntity.get(URI.create("http://api.nbp.pl/api/exchangerates/tables/A"))
                .accept(MediaType.APPLICATION_JSON)
                .build();
        final RequestEntity<Void> requestB = RequestEntity.get(URI.create("http://api.nbp.pl/api/exchangerates/tables/B"))
                .accept(MediaType.APPLICATION_JSON)
                .build();

        final ResponseEntity<? extends Collection<NbpResponse>> responseA = restTemplate.exchange(requestA, new ParameterizedTypeReference<Collection<NbpResponse>>() {
        });
        final Collection<NbpCurrency> listA = responseA.getBody().stream().findAny().get().getRates();

        final ResponseEntity<? extends Collection<NbpResponse>> responseB = restTemplate.exchange(requestB, new ParameterizedTypeReference<Collection<NbpResponse>>() {
        });
        final Collection<NbpCurrency> listB = responseB.getBody().stream().findAny().get().getRates();

        Map<String, CurrencyRate> currencies = Stream.concat(listA.stream(), listB.stream())
                .map(NbpConnector::toCurrencyRate)
                .collect(Collectors.toMap(
                        CurrencyRate::getCode,
                        Function.identity()
                ));

        currencies.put("PLN", new CurrencyRate("PLN", BigDecimal.valueOf(1).setScale(2)));
        return  currencies;
    }

    private static CurrencyRate toCurrencyRate(NbpCurrency currency) {
        final String code = currency.getCode();
        final String mid = currency.getMid();
        return new CurrencyRate(code, new BigDecimal(mid));
    }
}
