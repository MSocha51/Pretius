package pl.socha.exchanger.controller.dto;

public class CurrencyExchangeResponse {

    private String value;
    private String currency;
    private String previousValue;
    private String previousCurrency;

    private CurrencyExchangeResponse(CurrencyExchangeResponseBuilder builder) {
        value = builder.value;
        currency = builder.currency;
        previousValue = builder.previousValue;
        previousCurrency = builder.previousCurrency;
    }

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPreviousValue() {
        return previousValue;
    }

    public String getPreviousCurrency() {
        return previousCurrency;
    }

    public static CurrencyExchangeResponseBuilder builder(){
        return new CurrencyExchangeResponseBuilder();
    }

    public static class CurrencyExchangeResponseBuilder {
        private String value;
        private String currency;
        private String previousValue;
        private String previousCurrency;

        private CurrencyExchangeResponseBuilder(){

        }

        public CurrencyExchangeResponseBuilder value(String value){
            this.value = value;
            return this;
        }

        public CurrencyExchangeResponseBuilder currency(String currency){
            this.currency = currency;
            return this;
        }

        public CurrencyExchangeResponseBuilder previousValue(String previousValue){
            this.previousValue = previousValue;
            return this;
        }

        public CurrencyExchangeResponseBuilder previousCurrency(String previousCurrency){
            this.previousCurrency = previousCurrency;
            return this;
        }

        public CurrencyExchangeResponse build(){
            return new CurrencyExchangeResponse(this);
        }
    }


}
