package iowritestring.school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Register {
    /*
    egy iskolai naplózó rendszert kell megvalósítanod.
    Készíts a school csomagban egy Diary nevű osztályt benne egy newMark() metódussal,
    ami paraméterül várja a tanuló nevét és egy jegyet!
    Ha létezik a "tanulo_neve.txt" akkor a jegyet hozzáfűzi az állomány végére.
    Ha nem, akkor egy új állományt hoz létre "tanulo_neve.txt" formátumban, és beleírja a jegyet.
    Azt, hogy létezik-e egy fájl a Files.exists(path) metódussal tudod eldönteni.
    A fájlok a src/main/resources/ könyvtárban legyenek!

    Az év végén a tanár szeretné a tanuló fájl utolsó sorába az átlagot beírni.
    Írj egy metódust average() névvel, ami a fájl utolsó sorába a jegyek átlagát írja be! Például "average: 5".
     */
    public void newMark(Path file, int mark){
//        Path file= Path.of("src/main/resources/"+ name+".txt");
        if(Files.exists(file)){
            try {
                Files.writeString(file, mark+ "\n", StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new IllegalStateException("cannot write file");
            }
        }else{
            try {
                Files.writeString(file, mark+ "\n");
            } catch (IOException e) {
                throw new IllegalStateException("cannot write file");
            }
        }

    }
    public void average(Path file){
//        Path file= Path.of("src/main/resources/"+ name+".txt");
        if(!Files.exists(file)){
            throw new IllegalStateException("File do not exist");
        }
        List<String> marks= new ArrayList<>();
        try {
            marks= Files.readAllLines(file);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
        double sum=0;
        int count=0;
        for(String str: marks){
            sum+= Integer.parseInt(str);
            count++;
        }
        double average= sum/ count;

        try {
            Files.writeString(file, "average: " + average, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new IllegalStateException("can not write file");
        }
    }
}
