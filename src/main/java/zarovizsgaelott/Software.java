package zarovizsgaelott;

public abstract class Software {
    /*
    Mégiscsak egy kis gyakorlás a vizsgára: Hozzatok létre egy Software osztályt, melynek van egy name  attribútuma!
    Legyen egy price attribútuma is! Ne lehessen példányosítani! Legyen egy  void increasePrice() metódusa!
    Legyen konstruktora, mely a két attribútum értékét várja! Kell getter is a két attribútumhoz.
    Hozzatok létre egy OfficeSoftware és egy DeveloperSoftware osztályt, mely a Software leszármazottja.
    Legyen egy increasePrice() metódusa, mely OfficeSoftware  esetén az árat 5%-kal, a DeveloperSoftware árát 10%-kal emeli.
    Írj a két leszármazotthoz teszteseteket!
     */
    String name;
    int price; //public v.

    public abstract void increasePrice();

    public Software(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
