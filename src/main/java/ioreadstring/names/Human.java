package ioreadstring.names;

public class Human {
    /*
    egy szöveges állományból nevek beolvasása és eltárolása egy listába.
    A megoldáshoz két osztály kell megvalósítanod.
    A Human osztály reprezentál egy embert. Két adattagja vezeték- illetve keresztnév.
    A FileManager osztály felelős a fájl feldolgozásért. Egy Path típusú attribútumon keresztül érjük el a fájlt,
    míg a readFromFile() metódus felelős a beolvasásért és a Human objektumok létrehozásáért.
     */
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
