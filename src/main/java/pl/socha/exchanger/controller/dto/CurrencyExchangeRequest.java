package pl.socha.exchanger.controller.dto;

public class CurrencyExchangeRequest {

    private String value;
    private String currency;
    private String targerCurrency;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTargerCurrency() {
        return targerCurrency;
    }

    public void setTargerCurrency(String targerCurrency) {
        this.targerCurrency = targerCurrency;
    }
}
