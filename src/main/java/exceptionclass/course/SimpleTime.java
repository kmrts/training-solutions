package exceptionclass.course;

public class SimpleTime {
    /*
    Készíts egy SimpleTime osztályt, amely egyszerűsített időpont reprezentáló osztály.

Lehet létrehozni óra és perc megadásával és lehet időpontot megadni "hh:mm" alakú String-el is.
Legyen felüldefiniálva a toString úgy, hogy "hh:mm" alakú időt adjon.
Legyen getHour, és getMinute metódusa is.
Hibakezelés:
Definiálj egy saját InvalidTimeException-t, amely RuntimeException leszármazott.
Dobjon InvalidTimeException-t "Hour is invalid (0-23)" szöveggel, ha a konstruktornak nem megfelelő óra értéket adnak meg.
Dobjon InvalidTimeException-t "Minute is invalid (0-59)" szöveggel ha a perc hibás.
Dobjon InvalidTimeException-t "Time is null" szöveggel ha null String-et adnak meg.
Dobjon InvalidTimeException-t "Time is not hh:mm", ha érvénytelen a String formátuma.

Készíts egy Course osztályt. A kurzusnak van neve (name) és kezdete (begin),
ami SimpleTime típusú. Legyen konstruktora, ahol megkapja az adatokat, legyenek getterei,
valamint legyen felüldefiniálva a toString-je úgy, hogy hh:mm: kurzusnév alakú legyen.
     */
    private int hour;
    private int minute;

    public SimpleTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public SimpleTime(String hourminute) {
        this.hour = Integer.parseInt(hourminute.substring(0, 2) );
        this.minute = Integer.parseInt(hourminute.substring(3) );
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    @Override
    public String toString() {
        return String.format("2d%:2d%", hour, minute);
    }
}
