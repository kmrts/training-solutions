package week09d03;

import java.util.List;

public class SantaClaus {
    // Legyen egy SantaClaus osztály, akinek van egy Person listája, amit konstruktorban kap meg.
    // Legyen neki egy getThroughChimneys() metódusa, ami végigmegy az emberek listáján
    // és meghívja minden ember setPresent() metódusát.

    private List<Person> people;

    public SantaClaus(List<Person> people) {
        this.people = people;
    }

//    public List<Person> getPeople() {
//        return people;
//    }

    public void getThroughChimneys(){
        for(Person p: people){
            p.setPresent();
        }
    }
}
