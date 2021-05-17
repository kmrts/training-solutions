package week07d03.senior;

public class Date {
    /*
    Készítsünk egy Date osztályt, mely az alábbi attribútumokkal rendelkezik: int year, int month, int day.
    Az összes attribútum legyen final! Készítsünk továbbá egy statikus of metódust, mely a year, month és day paramétereket várja
    és létrehoz egy Date objektumot ezek alapján.
    Legyen továbbá a Date-nek egy withYear(int year), withMonth(int month) és egy withDay(int day) metódusa,
    melyek egy új Date objektumot adnak vissza az eredeti Date objektum adataival, azzal a különbséggel,
    hogy az új objektum a megadott paraméter értékét tartalmazza a megfelelő helyen (year, month vagy day).
     */
    private final int year;  //konstr. nélk hiba
    private final int month;
    private final int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "Date{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public static Date of(int year, int month, int day){
        return new Date(year, month, day);
    }
    public Date withYear(int year){
        return of(year, this.month, this.day);
    }
    public Date withMonth(int month){
        return of(this.year, month, this.day);
    }
    public Date withDay(int day){
        return of(this.year, this.month, day);
    }

    public static void main(String[] args) {
        Date date1= Date.of(1988, 5,5);
        System.out.println(date1);

        Date date2= date1.withDay(17);
        System.out.println(date2);

        Date date3= date2.withYear(1985);
        System.out.println(date3);
    }
}
