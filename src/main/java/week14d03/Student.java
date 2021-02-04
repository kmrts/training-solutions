package week14d03;

import java.util.*;

public class Student implements Comparable<Student>{  //<Student>
    /*
    egy diák jegyeit tárolod egy Map-ben. A map kulcsa a tantárgy, értéke pedig az adott tantárgy jegyeinek listája.
    Ezen felül a diáknak legyen neve, melyet konstruktorban kap meg.
    Legyen benne egy metódus, ami paraméterül vár egy tantárgyat és egy jegyet, és beírja a jegyet a megfelelő tantárgyhoz.
    Készítsd el a `ClassNotebook` nevű osztályt melyben diákok listája található.
    Készíts egy lekérdező metódust a `ClassNoteBook` osztályban, legyen a neve `sortNotebook`
     mely a diákok listáját ABC sorrendben adja vissza.
     */
    private String name;
    private Map<String, List<Integer>> notes= new TreeMap<>();

    public Student(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void addRating(String subject, Integer rating){
        if(!notes.containsKey(subject)){
            notes.put(subject, new ArrayList<>());
        }
        notes.get(subject).add(rating);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ratings=" + notes +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }


}
