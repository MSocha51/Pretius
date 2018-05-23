package pl.socha.exchanger.domain;

import java.math.BigDecimal;

public class CurrencyRate {

    private String code;
    private BigDecimal mid;

    public CurrencyRate(String code, BigDecimal mid) {
        this.code = code;
        this.mid = mid;
    }

    public String getCode() {
        return code;
    }

    public BigDecimal getMid() {
        return mid;
    }

}
