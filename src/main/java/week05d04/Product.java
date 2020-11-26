package week05d04;

import java.time.LocalDate;

public class Product {
    //egy termékről tárolod a nevét és a lejárati dátumát (LocalDate). Legyen egy konstruktora, ami a nevet kapja meg
    // illetve a lejárati dátumot három részletben int year, int month, int day. (public Product(String name, int year, int month, int day))
    //A lejárati dátumot a konstruktorban állítsd össze.
    //Legyen mindkettőhöz getter metódus.

    private String name;
    private LocalDate date;

    public Product(String name, int year, int month, int day) {
        this.name = name;
        this.date = date.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
