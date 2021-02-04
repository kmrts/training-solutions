package week14d03;

import java.util.*;

public class ClassNotebook {
    private List<Student> students= new ArrayList<>();

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNotebook(){
//        Set<Student> ordered= new TreeSet<>();
////        for(Student st: students){
////            ordered.add(st);
////
////        }
//        ordered.addAll(students);
//        return ordered;

        List<Student> ordered= new ArrayList<>();

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.hashCode()- o2.hashCode();
//                return o1 - o2;
            }
        });
        return students;

    }

    @Override
    public String toString() {
        return "ClassNotebook{" +
                "students=" + students +
                '}';
    }
}
