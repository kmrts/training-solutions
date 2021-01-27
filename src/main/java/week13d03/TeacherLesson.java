package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TeacherLesson {
    /*
    Adott a következő szerkezetű fájl, beosztas.txt:
Albatrosz Aladin
biologia
9.a
2
Albatrosz Aladin
osztalyfonoki
9.a
1
Csincsilla Csilla
matematika
9.b
2
A fájl tantárgyfelosztást tartalmaz.
A tanttárgyfelosztást 4-es blokkokban adjuk meg.
Első sor a tanár neve, majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
Írj egy metódust, ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten.
     */
    public int countTeachersLessonsPerWeek(Path source, String name){

        try (BufferedReader brd = Files.newBufferedReader(source)) {
            int count= 0;
            String line;
            while ( (line= brd.readLine()) != null){
                if(line.equals(name)){
//                    String nextLine= brd.readLine();
//                    nextLine= brd.readLine();
//                    nextLine= brd.readLine();
                    for(int i=0; i<3; i++){
                        line= brd.readLine();
                    }
                    count+= Integer.parseInt(line);
                }
            }
            return count;
        }catch (IOException ioe){
            throw new IllegalStateException("can not read file", ioe);
        }

    }
}
