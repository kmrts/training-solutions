package schoolrecords;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClassRecords {

    private String className;
    private Random rnd;
    private List<Student> students = new ArrayList<>();

    public ClassRecords(String className, Random rnd) {
        this.className = className;
        this.rnd = rnd;
//        this.students = students;
    }

    public String getClassName() {
        return className;
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                return false;
            }
        }
        students.add(student);
        return true;
    } // felvesz egy diákot az osztályba

    public boolean removeStudent(Student student) {
        for (Student s : students) {
            if (s.getName().equals(student.getName())) {
                students.remove(student);
                return true;
            }
        }
        return false;
    } //kivesz egy diákot az osztályból

    public double calculateClassAverage() {
        if (students.size() == 0) {
            throw new ArithmeticException("No student in the class, average calculation aborted!");
        } else {
            double sum = 0; //
            for (Student s : students) {
                if (s.getMarks().size() == 0) {
                    throw new ArithmeticException("No marks present, average calculation aborted!");
                } else {
                    sum += s.calculateAverage();
                }

            }
            return Math.round(sum / students.size() * 100) / 100.0;
        }

    } //osztályátlagot számol, minden diákot figyelembe véve

    public double calculateClassAverageBySubject(Subject subject) {
        double sum = 0;
        int count = 0;
        for (Student s : students) {
            for (Mark m : s.getMarks()) {
                if (m.getSubject().getSubjectName().equals(subject.getSubjectName())) {
//                    sum += s.calculateSubjectAverage(subject);
//                    System.out.println(s.calculateSubjectAverage(subject));
                    sum += m.getMarkType().getValue();
                    count++;
//                    break;
                }
            }
        }
//        System.out.println(sum);
//        System.out.println(count);

        return Math.round(sum / count * 100) / 100.0;
    } //tantárgy szerinti osztályátlagot számol,
    // kihagyja azon diákokat, akiknek az adott tantárgyból nincs jegye

    public Student findStudentByName(String name) {
        if (isEmpty(name)) {
            throw new IllegalArgumentException("Student name must not be empty!");
        } else if (students.size() == 0) {
            throw new IllegalStateException("No students to search!");
        } else {
            for (Student s : students) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
        }

        throw new IllegalArgumentException("Student by this name cannot be found! " + name);  ////

    } // név szerint megkeres egy diákot az osztályban

    public Student repetition() {

//        rnd.nextInt(students.size());
        if (students.size() == 0) {
            throw new IllegalStateException("No students to select for repetition!");
        } else {
            return students.get(rnd.nextInt(students.size()));
        }

    } //felelethez a listából random módon kiválaszt egy diákot

    public List<StudyResultByName> listStudyResults() {

        List<StudyResultByName> sList = new ArrayList<>();
        for (Student s : students) {
            sList.add(new StudyResultByName(s.getName(), s.calculateAverage()));
        }
        return sList;
    } //a diákok nevét és tanulmányi átlagát egy-egy új objektumba viszi,
    // és azok listáját adja vissza

    public String listStudentNames() {
        String toList = "";
        for (Student s : students) {
            if (!isEmpty(toList)) {
                toList = toList.concat(", ");
            }
            toList = toList.concat(s.getName());
        }
        return toList;

    } //kilistázza a diákok neveit, vesszővel elválasztva

    private boolean isEmpty(String str) {
        if ("".equals(str)) {
            return true;
        } else {
            return false;
        }

    }
}
