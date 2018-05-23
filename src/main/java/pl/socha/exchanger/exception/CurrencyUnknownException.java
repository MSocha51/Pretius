package pl.socha.exchanger.exception;

public class CurrencyUnknownException extends RuntimeException{

    public CurrencyUnknownException(String msg, Throwable ex){
        super(msg, ex);
    }

    public CurrencyUnknownException(String msg){
        super(msg);
    }
}
