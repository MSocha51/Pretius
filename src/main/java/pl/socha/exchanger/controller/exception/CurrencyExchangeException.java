package pl.socha.exchanger.controller.exception;

public class CurrencyExchangeException extends RuntimeException{

    public CurrencyExchangeException(String msg, Throwable ex){
        super(msg, ex);
    }

    public CurrencyExchangeException(String msg){
        super(msg);
    }
}
