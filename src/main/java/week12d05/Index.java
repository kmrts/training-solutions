package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Index {
    /*
    Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány!
    Másold be a projektedbe (index.html) néven! Ez egy szöveges állomány.
    Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó! (edited)
     */
    public int countWord(String word){
        Path file= Path.of("index.html");
        int count= 0;
        try (BufferedReader bur = Files.newBufferedReader(file)) {
            String nextLine;
            while( ( nextLine= bur.readLine() ) != null ){
                if(nextLine.contains(word)){
                    count++;
                }
            }
        }catch (IOException ex){
            throw new IllegalStateException("can not read file", ex);
        }
        return count;
    }

    public static void main(String[] args) {
        int i= new Index().countWord("koro"); // 29
        System.out.println(i);

        Index ind= new Index();

        System.out.println(ind.countWord("koronavírus")); //7
        System.out.println(ind.countWord("koronavirus")); //16
        System.out.println(ind.countWord("vakcina")); //9
        System.out.println(ind.countWord("szex")); // 9
        System.out.println(ind.countWord("medve")); // 2
        System.out.println(ind.countWord("Orbán"));// 2
        System.out.println(ind.countWord("Merkel"));// 1
        System.out.println(ind.countWord("Putyin"));// 1
        System.out.println(ind.countWord("magyar")); // 18
        System.out.println(ind.countWord("pénz")); // 2

    }
}
