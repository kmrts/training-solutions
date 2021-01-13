package week11d02;

public class Ride {
    /*
    A feladatban egy biciklis futár egy heti munkáját rögzítjük és készítünk statissztikákat.
A futár minden fuvar után feljegyzi, hogy a hét hányadik napján történt a fuvar.
Ezután azt, hogy az adott nap hányadik fuvarját teljesítette és ezután azt, hogy hány kilométer volt az adott fuvar.
A futár egy-egy fuvarját reprezentálja a Ride nevű osztály, adatagokkal, konstruktorra, getterekkel.
Készítsd el a Courier osztályt.
     */
    private int day;
    private int number;
    private int way;

    public Ride(int day, int number, int way) {
        this.day = day;
        this.number = number;
        this.way = way;
    }

    public int getDay() {
        return day;
    }

    public int getNumber() {
        return number;
    }

    public int getWay() {
        return way;
    }
}
