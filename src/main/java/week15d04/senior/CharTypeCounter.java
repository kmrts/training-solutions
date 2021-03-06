package week15d04.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CharTypeCounter {


    /*
        Számoljuk össze, hogy egy fájlban hány mássalhangzó, hány magánhangzó és hány egyéb karakter van.
        A space-eket ne vegyük figyelembe! A kis- és nagybetű különbség nem számít!
    Remélem a juniorok is meg tudják oldani, azonban a senoiroknak streammel kell. Bonyi!!!
         */
    private Map<CharType, Integer> chartypeSum= new TreeMap<>();

    private static Set<Character> vowels= new HashSet<>();
    private static Set<Character> consonants= new HashSet<>();

    static {
        String vow= "aáeéiíoóöőuúüű";
        for(char c: vow.toCharArray()){
            vowels.add(c);
        }

        String cons= "bcdfghjklmnpqrstvwyz";
        for(char c: cons.toCharArray()){
            consonants.add(c);
        }
    }

    public CharTypeCounter() {
        chartypeSum.put(CharType.VOWEL, 0);
        chartypeSum.put(CharType.CONSONANT, 0);
        chartypeSum.put(CharType.OTHER, 0);
    }

    public Map<CharType, Integer> getChartypeSum() {
        return new HashMap<>(chartypeSum);
    }

    public void readLines(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine())  != null) {

            countAndPutToMap(line.toLowerCase());
        }
    }

    private void countAndPutToMap(String line) {
        for(char ch: line.toCharArray()){
            if(vowels.contains(ch)){
                chartypeSum.put(CharType.VOWEL, chartypeSum.get(CharType.VOWEL) +1);
            }else if(consonants.contains(ch)){
                chartypeSum.put(CharType.CONSONANT, chartypeSum.get(CharType.CONSONANT) +1);
            }else if( ch!=' '){
                chartypeSum.put(CharType.OTHER, chartypeSum.get(CharType.OTHER) +1);
            }
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("vowcons.txt"))) {
            CharTypeCounter ctc= new CharTypeCounter();
            ctc.readLines(reader);

            System.out.println(ctc.getChartypeSum());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

    }
}
