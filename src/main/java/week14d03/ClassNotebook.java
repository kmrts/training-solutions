package week14d03;

import java.util.*;

public class ClassNotebook {
    private List<Student> students= new ArrayList<>();

    public ClassNotebook(List<Student> students) {
        this.students = students;
    }

    public List<Student> sortNotebook(){


//        Collections.sort(students);
//        return students;

        List<Student> result= new ArrayList<>(students);

        Collections.sort(result);
        return result;

    }

    @Override
    public String toString() {
        return "ClassNotebook{" +
                "students=" + students +
                '}';
    }
}
