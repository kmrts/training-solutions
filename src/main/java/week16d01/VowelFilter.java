package week16d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class VowelFilter {
    /*
    Írj egy VowelFilter.filterVowels(BufferedReader reader) metódust,
     mely beolvas egy fájlt soronként, kiszűri belőle a magánhangzókat, és visszaadja egy String-ként.

Tehát a bemeneti fájl tartalma:

Aprócska
Kalapocska
Benne
Csacska
Macska
Mocska

Kimenet Stringként:

prcsk
Klpcsk
Bnn
Cscsk
Mcsk
Mcsk

     */
    private String vowelstr= "aáeéiíoóöőuúüű";
    private Set<Character> vowels= new HashSet<>();

    public VowelFilter() {
        for(Character ch: vowelstr.toCharArray()){
            vowels.add(ch);
        }
    }

    public Set<Character> getVowels() {
        return vowels;
    }


    public String filterVowels(BufferedReader reader) throws IOException{
        StringBuilder sb= new StringBuilder();
        String line;
        while( (line= reader.readLine()) != null){

            for(Character c: line.toCharArray()){
                char clow= Character.toLowerCase(c);
                if(!vowels.contains(clow)){
                    sb.append(c.toString());
                }
            }
            sb.append("\n");

        }
        sb.deleteCharAt(sb.length()-1);

        return sb.toString();

    }

    public static void main(String[] args) {

        try (BufferedReader reader = Files.newBufferedReader(Path.of("inputtext.txt"))) {
            VowelFilter vf= new VowelFilter();

            System.out.println(vf.filterVowels(reader));

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
