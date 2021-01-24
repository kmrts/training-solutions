package week12d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Index {
    /*
    Töltsd le az index.hu nyitólapját böngészőből, ez egy html állomány!
    Másold be a projektedbe (index.html) néven! Ez egy szöveges állomány.
    Olvasd be, és számold meg, hány sorban szerepel a koronavírus szó! (edited)
     */
    public int countWord(String word) {
        Path file = Path.of("index.html");
        int count = 0;
        try (BufferedReader bur = Files.newBufferedReader(file)) {
            String nextLine;
            while ((nextLine = bur.readLine()) != null) {
                if (nextLine.contains(word)) {
                    count++;
                }
            }
        } catch (IOException ex) {
            throw new IllegalStateException("can not read file", ex);
        }
        return count;
    }

    public String countCycle(List<String> searchWords) {
        StringBuilder sb = new StringBuilder();
        for (String st : searchWords) {
            sb.append(String.format("%s(%d) ", st, countWord(st)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        int i = new Index().countWord("koro"); // 29
//        System.out.println(i);

        Index ind = new Index();
        List<String> list= new ArrayList<>(Arrays.asList("koro", "koronavírus", "koronavirus", "vakcina", "oltás", "szex", "medve",
                "majom", "Orbán", "Merkel", "Putyin", "Trump", "Kamala", "Müller", "pénz", "magyar", "java", "42",
                "kobra", "python", "anakonda","c"));
        System.out.println(ind.countCycle(list));

    }
}
