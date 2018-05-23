package pl.socha.exchanger.nbpconnect;

import java.util.Collection;
import java.util.List;

class NbpResponse {

    private String table;
    private String no;
    private String effectiveDate;
    private Collection<NbpCurrency> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Collection<NbpCurrency> getRates() {
        return rates;
    }

    public void setRates(List<NbpCurrency> rates) {
        this.rates = rates;
    }
}
