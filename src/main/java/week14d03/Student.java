package week14d03;

import java.util.*;

public class Student{
    /*
    egy diák jegyeit tárolod egy Map-ben. A map kulcsa a tantárgy, értéke pedig az adott tantárgy jegyeinek listája.
    Ezen felül a diáknak legyen neve, melyet konstruktorban kap meg.
    Legyen benne egy metódus, ami paraméterül vár egy tantárgyat és egy jegyet, és beírja a jegyet a megfelelő tantárgyhoz.
    Készítsd el a `ClassNotebook` nevű osztályt melyben diákok listája található.
    Készíts egy lekérdező metódust a `ClassNoteBook` osztályban, legyen a neve `sortNotebook`
     mely a diákok listáját ABC sorrendben adja vissza.
     */
    private String name;
    private Map<String, List<Integer>> ratings= new TreeMap<>();

    public Student(String name) {
        this.name = name;
//        this.ratings= new TreeMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, List<Integer>> getRatings() {
        return ratings;
    }

    public void addRating(String subject, Integer rating){
        if(!ratings.containsKey(subject)){
            ratings.put(subject, new ArrayList<>());
        }
        ratings.get(subject).add(rating);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ratings=" + ratings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

//    @Override
//    public int compareTo(Student o) {
//        return this.name - (Student)o.getName();
//    }

//    @Override
//    public int compareTo(Student o) {
//        return this.equals(o);
//    }
}
