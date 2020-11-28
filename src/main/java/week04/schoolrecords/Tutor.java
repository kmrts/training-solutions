package week04.schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Tutor {
    private String name;
    private List<Subject> taughtSubjects = new ArrayList<>();

    public Tutor(String name, List<Subject> taughtSubjects) {
        this.name = name;
        this.taughtSubjects = taughtSubjects;
    }

    public String getName() {
        return name;
    }

    public boolean tutorTeachingSubject(Subject subject) {
//        if(taughtSubjects.g.contains(subject.getSubjectName())){
//            return true;
//        }else{
//            return false;
//        }
        boolean contains = false;
        for (Subject s : taughtSubjects) {
            if (s.getSubjectName() == subject.getSubjectName()) {
                contains = true;
                break;
            }
        }
        return contains;

    }
}
