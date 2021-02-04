package week14d03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClassNotebookTest {

//    @BeforeEach
//    void setUp(){
//        Student s1= new Student("Jaques");
//        s1.addRating("matek", 5);
//        s1.addRating("matek", 4);
//        s1.addRating("magyar", 3);
////        System.out.println(s1);
//
//        Student s2= new Student("Béla");
//        s2.addRating("fizika", 3 );
//        s2.addRating("filozófia", 2 );
////        System.out.println(s2);
//    }

    @Test
    public void testSortNotebook(){
        Student s1= new Student("Jaques");
        s1.addRating("matek", 5);
        s1.addRating("matek", 4);
        s1.addRating("magyar", 3);
        System.out.println(s1);

        Student s2= new Student("Béla");
        s2.addRating("fizika", 3 );
        s2.addRating("filozófia", 2 );
        System.out.println(s2);

        ClassNotebook cn= new ClassNotebook(Arrays.asList(s1, s2));
        System.out.println(cn);
        cn.sortNotebook();
        System.out.println(cn);

    }

}