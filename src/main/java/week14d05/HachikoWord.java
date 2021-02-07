package week14d05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HachikoWord {
    /*
    A examples/week14d05/hachiko.srt van a Hachiko film felirata. Írj egy
countWords() metódust, mely paraméterül várja a fájlt, varargsban
szavakat. Megszámolja, hogy melyik szó hány sorban szerepel a
szövegben. Legyenek mondjuk a beadott szavak: "Hachiko", "haza",
"pályaudvar", "jó"
     */
    private Map<String, Integer> wordCount = new TreeMap<>();

    public Map<String, Integer> getWordCount() {
        return wordCount;
    }

    public void countWords(Path path, String... words) {
        initArray(words);

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while ((line = br.readLine()) != null) {

                countFromArray(line, words);
//                for (String word : words) {
//                    if (line.contains(word)) {
//                            if( ! wordCount.containsKey(word)){
//                                wordCount.put(word, 1);
//                            } //else
//                            wordCount.put(word, wordCount.get(word) +1);
//                    }
//                }
            }

        } catch (IOException ioe) {
            throw new IllegalArgumentException("cannot read file", ioe);
        }

    }
    private void initArray(String...words){
        for (String s: words){
            wordCount.put(s, 0);
        }
    }
    private void countFromArray(String line, String... words){
        for (String word : words) {
            if (line.contains(word)) {

                wordCount.put(word, wordCount.get(word) +1);
            }
        }
    }

    @Override
    public String toString() {
        return "HachikoWord{" +
                "wordCount=" + wordCount +
                '}';
    }
}
