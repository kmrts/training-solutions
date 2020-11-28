package week04.schoolrecords;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Mark> marks= new ArrayList<>();
    private String name;

    public Student(String name) {
        if("".equals(name)){
            throw new IllegalArgumentException("Student name must not be empty!");
        }else{
            this.marks = marks;
            this.name = name;
        }
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
//        return name+ " marks: " + marks.get(0).getSubject().getSubjectName() +": " + marks.get(0);
        String toS= name+ " marks:";
        for(Mark m: marks){
            toS+= " "+ m.getSubject().getSubjectName() +": " + m;
        }
        return toS;
    }

    public void grading(Mark mark){
        if(mark==null){
            throw new NullPointerException("Mark must not be null!");
        }else{
            marks.add(mark);
        }
    } // érdemjegy rögzítése

    public double calculateAverage(){
        int sum= 0;
        for(Mark m: marks){
            sum+=m.getMarkType().getValue();
        }
        return Math.round((double)sum / marks.size() *100) /100.0; //2 jegyre ker., kell a .0 a végén

    } // teljes átlag számolása
    public double calculateSubjectAverage(Subject subject){
        int sum= 0;
        int count= 0;
        for(Mark m: marks){
            if(m.getSubject().equals(subject)){
                sum+=m.getMarkType().getValue();
                count++;
            }
        }
        return Math.round( (double)sum / count *100) /100.0;

    } // tantárgyhoz tartozó átlag számítása

//    private boolean isEmpty(String str){
//
//    }

}
