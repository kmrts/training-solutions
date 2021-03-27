package week05d04.senior;

public class Product {

    //enum-os és enum nélküli mego.

    private long price;
    //    private String currency;
    private Currency currency;

    private static final double ARF = 300.0;

    public Product(long price, Currency currency) {
        this.price = price;

//        if(currency.equals("HUF") || currency.equals("USD")){
//            this.currency = currency;
//        }else{
//            throw new IllegalArgumentException("illegal currency");
//        }
        if (currency == Currency.HUF || currency == Currency.USD) {
            this.currency = currency;
        } else {
            throw new IllegalArgumentException("currency must be HUF or USD");
        }
    }

    public double convertPrice(Currency currency) {
//        if(currency.equals(this.currency)){
//            return (double)price;
//        }
//
//        return currency.equals("USD") ? price/ ARF : price* ARF;

        if (currency== this.currency) {
            return (double) price;
        }

        return currency == Currency.USD ? price / ARF : price * ARF;
    }
}
