package defaultconstructor.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SimpleDateFormatter {
    // a másik az alapértelmezett országkódot használja.
    // Ezt az osztály paraméter nélküli konstruktora állítja be.
    private CountryCode defaultCountry; ////

    public SimpleDateFormatter() {
        this.defaultCountry = CountryCode.HU;  ////
    }

    public String formatDateString(SimpleDate simpleDate){
//        LocalDate ld= LocalDate.of(simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay());
//        return ld.format(DateTimeFormatter.ofPattern("yyyy-M-dd"));
        return formatDateStringByCountryCode(defaultCountry, simpleDate);  ////
    }
    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate){
        LocalDate ld= LocalDate.of(simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay());
        String pattern="";
        switch (countryCode){
            case EN:
                pattern= "dd-M-yyyy";
                break;
            case US:
                pattern= "M-dd-yyyy";
                break;
            case HU:
                pattern= "yyyy-M-dd";
                break;
        }
        return ld.format(DateTimeFormatter.ofPattern(pattern));
    }

}
