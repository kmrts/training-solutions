package week11d05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesSum {
    /*
    Adott az aktuális könyvtárban több, fájl, melynek a nevei: number00.txt, number03.txt, number20.txt, egészen 99-ig.
Nem minden fájl létezik, lehet, hogy bizonyos számhoz tartozó fájl kimaradt. Olvasd be az állományból a benne lévő
számot, és ezt összegezd! Használd a Files.isRegularFile() metódust arra, hogy megnézd, létezik-e a fájl!
Használd a Files.readString() metódust a fájl beolvasására! A FilesSum osztály sumNumbers(InputStream) metódusába dolgozz!
     */
    public double sumNumbers(){
        double sum=0;
        String cont= null;
        for (int i = 0; i <100 ; i++) {
            String name= String.format("number%02d.txt", i);
            Path file= Path.of(name);
            if(Files.isRegularFile(file)){
//                String cont= null;
                try {
                    cont= Files.readString(file);
                } catch (IOException e) {
                    throw new IllegalStateException("can not read file", e);
                }
                sum+= Integer.parseInt(cont);

            }
        }
        return sum;
    }
}
