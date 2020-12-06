package initalizer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    //A hitelkártya "használatba vételekor" (CreditCard osztály betöltése) az aktuális átváltási faktorok (Rate)
    // feltöltésre kerülnek a CreditCard osztályba, egy statikus final listába (statikus inicializálás).
    //
    //konstruktorok:    //
    //public CreditCard(long balance, Currency currency)
    //public CreditCard(long balance)


    private long balance;
    private static List<Rate> rates = new ArrayList<>();  ///

    static {
        final List<Rate> ACTUAL_RATES = new ArrayList<>();     ///
        ACTUAL_RATES.add(new Rate(Currency.HUF, 1.0));
        ACTUAL_RATES.add(new Rate(Currency.EUR, 308.23));
        ACTUAL_RATES.add(new Rate(Currency.SFR, 289.24));
        ACTUAL_RATES.add(new Rate(Currency.GBP, 362.23));
        ACTUAL_RATES.add(new Rate(Currency.USD, 289.77));

        rates= ACTUAL_RATES;   ////

    }

    public CreditCard(long balance, Currency currency, List<Rate> rates) {
        double convFact= 0;
        for(Rate r: rates){
            if(r.getCurrency()== currency){
                convFact= r.getConversionFactor();
            }
        }
        this.balance= (long)(balance* convFact);

    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        double convFact=0;

        for(Rate r: rates){
            if(r.getCurrency()==(currency)){
                convFact= r.getConversionFactor();
                break;
            }
        }
        if((long)(amount *convFact) <= balance){
            balance -= (long)(amount* convFact);
            return true;
        }
        return false;
    }
    public boolean payment(long amount) {
        if(amount<=balance){
            balance -= amount;
            return true;
        }
            return false;
    }
}
