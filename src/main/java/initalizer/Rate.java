package initalizer;

public class Rate {
    //A Rate osztály az egyes valutákhoz (Currency enum) tartozó átváltási faktorokat tárolja, ezek listájából dolgozik
    // a payment() metódus. Hozzuk létre a Currency enum-ot is HUF, EUR, SFR, GBP, USD értékekkel!
    //
    //konstruktor:
    //public Rate(Currency currency, double conversionFactor)
    //
    //publikus metódusok:
    //public Currency getCurrency()
    //public double getConversionFactor()
    private Currency currency;
    private double conversionFactor;

    public Rate(Currency currency, double conversionFactor) {
        this.currency = currency;
        this.conversionFactor = conversionFactor;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}
