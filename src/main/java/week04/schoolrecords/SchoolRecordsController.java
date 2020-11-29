package week04.schoolrecords;

import java.util.*;

public class SchoolRecordsController {

    private ClassRecords cl;
    private List<Subject> subjectList= new ArrayList<>();
    private List<Tutor> tutorList= new ArrayList<>();

    public SchoolRecordsController(ClassRecords cl) {
        this.cl = cl;
    }

    public ClassRecords getCl() {
        return cl;
    }

    public void initSchool(){
        subjectList.add(new Subject("matematika"));
        subjectList.add(new Subject("fizika"));
        subjectList.add(new Subject("kémia"));
        subjectList.add(new Subject("történelem"));
        subjectList.add(new Subject("informatika"));
        subjectList.add(new Subject("földrajz"));
        tutorList.add(new Tutor("Kiss Kitti", Arrays.asList(new Subject("kémia"))) );
        tutorList.add(new Tutor("Kovács Béla", Arrays.asList(new Subject("matematika"),
                new Subject("fizika"))) );
        tutorList.add(new Tutor("Jámbor János", Arrays.asList(new Subject("történelem"),
                new Subject("földrajz"))));

    }
    public void printMenu(){
        System.out.println("1. Diákok nevének listázása\n" +
                "2. Diák név alapján keresése\n" +
                "3. Diák létrehozása\n" +
                "4. Diák név alapján törlése\n" +
                "5. Diák feleltetése\n" +
                "6. Osztályátlag kiszámolása\n" +
                "7. Tantárgyi átlag kiszámolása\n" +
                "8. Diákok átlagának megjelenítése\n" +
                "9. Diák átlagának kiírása\n" +
                "10. Diák tantárgyhoz tartozó átlagának kiírása\n" +
                "11. Kilépés");
    }
    public void chooseFromMenu(){
        Scanner sc= new Scanner(System.in);

        boolean exit= false;
        while(!exit){
            printMenu();
            System.out.println("Válassz a menüből: ");

            switch (sc.nextLine()){
                case "1": //        Diákok nevének listázása - kilistázza a diákok neveit (listStudentNames())
                    System.out.println(cl.listStudentNames());
                    break;
                case "2": //        Diák név alapján keresése - bekéri a diák nevét, és a diák szöveges reprezentációját írja ki
//        (findStudentByName())
                    System.out.println("A keresendő diák neve: ");
                    System.out.println(cl.findStudentByName(sc.nextLine()));

                    break;
                case "3"://        Diák létrehozása - bekéri a diák nevét, és felviszi (new Student(), valamint addStudent())
                    System.out.println("A felvett diák neve: ");

                    cl.addStudent(new Student(sc.nextLine()));

                    break;
                case "4"://        Diák név alapján törlése - be kell kérni a nevét, és az első találatot törölni
//        (először egy findStudentByName() majd egy removeStudent() hívás)
                    System.out.println("A törlendő diák neve: ");
                    cl.removeStudent(cl.findStudentByName(sc.nextLine()));
                    break;
                case "5"://        Diák feleltetése - előbb sorsolni kell egy diákot, meg kell hívni a repetition() metódust,
//        bekérni az érdemjegyet, tárgy nevét, oktató nevét. A tárgyat és az oktatót kikeresni a listából,
//        példányosítani ezekkel egy Mark-ot, és meghívni a grading() metódust.
                    menu5();

                    break;
                case "6"://        Osztályátlag kiszámolása - calculateClassAverage() eredményének kiírása
                    System.out.println("Az osztályátlag: "+ cl.calculateClassAverage());
                    break;
                case "7"://        Tantárgyi átlag kiszámolása - calculateClassAverageBySubject() eredményének kiírása
                    System.out.println("Mely tárgy átlagára kíváncsi: ");
                    System.out.println(cl.calculateClassAverageBySubject(new Subject(sc.nextLine())));                    ;
                    break;
                case "8"://        Diákok átlagának megjelenítése - listStudyResults() eredményének kiírása
                    System.out.println(cl.listStudyResults()); //lista elemek tagolt kiírása...
                    break;
                case "9"://        Diák átlagának kiírása - be kell kérni a nevét,
                    // findStudentByName(), majd az eredményen calculateAverage()
                    System.out.println("A diák neve: ");
                    System.out.println(cl.findStudentByName(sc.nextLine()).calculateAverage());
                    break;
                case "10"://        Diák tantárgyhoz tartozó átlagának kiírása - be kell kérni a nevét, majd a tantárgy nevét.
//        findStudentByName(), majd ki kell keresni a tantárgyat a listából,
//        majd calculateSubjectAverage(Subject) hívás
                    System.out.println("A diák neve: ");
                    String stName= sc.nextLine();
                    System.out.println("A tantárgy neve: ");
                    String subjName= sc.nextLine();

                    System.out.println( cl.findStudentByName(stName).calculateSubjectAverage(new Subject(subjName)) );
                    break;

                case "11"://                Kilépés
                    exit= true;
                    break;
            }
        }
    }
    public void menu5(){
        Scanner sc=new Scanner(System.in);
        Student sNext = cl.repetition();
        System.out.println(sNext.getName());
        System.out.println("Felelés, "+sNext.getName()+ " érdemjegye: ");
        String note= sc.nextLine();
        System.out.println("Tantárgy neve: ");
        String subj= sc.nextLine();
        Subject s1=new Subject(subj);

        System.out.println("Tanár neve: ");
        String tut= sc.nextLine();
//        Tutor t1= new Tutor(tut);
//        boolean correct= false;
        for(Tutor t: tutorList){
            if(t.getName().equals(tut) && t.tutorTeachingSubject(s1)){
//                correct= true;
//                t1= t;
                System.out.println("van egyezés");
                Mark mark=new Mark(note, s1, t);

                sNext.grading(mark);
                System.out.println(sNext.getMarks().get(0));
                break;
            }
        }
    }
//    6-os néha no mmarks throw,
//    10-es rossz eredm,
//    8-as lista kiiratás formázandó


    public static void main(String[] args) {

        ClassRecords clr = new ClassRecords("6/A", new Random());
        SchoolRecordsController src= new SchoolRecordsController(clr);

        src.initSchool();
        src.chooseFromMenu();




    }
}
