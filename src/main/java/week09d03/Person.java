package week09d03;

import java.util.Random;

public class Person {

    // Készíts egy Present nevű enumot a következő felsorolókkal: Toy, Electronic, Housekepping, Decoration.
    // Ezek fogják az ajándékok típusát reprezentálni.
    // Készíts egy Person osztályt legyen neki neve és életkora és legyen egy Present típusú attribútuma.
    // A nevet és életkort konstruktorban kapja meg.
    // Legyen egy setPresent() metódusa ami beállítja az ajándék attribútumot véletlenszerűen, egy kitétel van,
    // 14 év fölötti nem kaphat játékot.
    // Ennek megvalósításához szabadon bővíthetőek az eddig elkészült elemek.

    private String name;
    private int age;
    private Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Present getPresent() {
        return present;
    }

    public void setPresent() {
        Random r = new Random();
        if (age <= 14) {
            present = Present.values()[r.nextInt(4)];
        }else{
            present= Present.values()[r.nextInt(3)+1];//1-3 lehet, 0 nem
        }

    }
}
