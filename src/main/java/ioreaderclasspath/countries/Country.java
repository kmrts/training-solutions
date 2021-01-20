package ioreaderclasspath.countries;

public class Country {
    /*
    A src/main/resources/country.txt állományban országnevek és a szomszédos országok száma található.
    Hozz létre egy az ország tárolására alkalmas osztályt Country néven!

Hozz létre egy CountryStatistics osztályt, ahol beolvasod file tartalmát egy listába,
amjd írj metódusokat amelyek visszatérési értéke választ ad a következő kérdésekre:
* Hány országot olvastál be?
* Melyik országnak van a legtöbb szomszédja?
     */
    private String name;
    private int borderCountries;

    public Country(String name, int borderCountries) {
        this.name = name;
        this.borderCountries = borderCountries;
    }

    public String getName() {
        return name;
    }

    public int getBorderCountries() {
        return borderCountries;
    }
}
