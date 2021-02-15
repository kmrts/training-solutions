package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Histogram {
    /*
    Olvass be egy szöveges fájlt soronként, melyben soronkont számok vannak.
    Majd hozz létre egy stringet, mely ugyanennyi sort tartalmaz, és annyi csillagot ír ki egymás mellé soronkont,
    amennyi a bemeneti fájlban lévő szám.
Azaz a bemeneti fájl:

3
4
1
2
A létrehozott String:

***
****
*
**

Figyelj, hogy az algoritmusod lehetőleg hatékony legyen!

A Histogram osztályba dolgozz, tesztje HistogramTest. Minden sor után legyen sortörés, az utolsó után is.
     */
    public String createHistogram(BufferedReader reader) throws IOException {
        String line;
        StringBuilder sb= new StringBuilder();
        while ((line = reader.readLine())  != null) {
            int times;
            try{
                times= Integer.parseInt(line);
            }catch (NumberFormatException ex){
                throw new IllegalArgumentException("Not a number", ex);
            }

            for(int i=0; i< times; i++){
                sb.append("*");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of("histogram.txt"))) {

            System.out.println(new Histogram().createHistogram(reader));
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

