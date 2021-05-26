package week07d04.senior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ShoppingList {
    /*
    A ShoppingList osztályba írj egy long calculateSum(String path) metódust,
    mely a paraméterként átadott fájlból beolvassa a bevásárlólista tartalmát, és összegzi az árat!
    A fájl a következő formátumú sorokat tartalmazza: kenyér;2;30,
    ahol az első a termék neve, a második a darabszám, a harmadik az egységár.
    Azaz ezen sor esetén 2 * 30 = 60 értékkel kell számolni.
     */
    public long calculateSum(String path){
        try (BufferedReader bfr = Files.newBufferedReader(Path.of(path))) {
            long sum= 0;
            String line;
            while ((line = bfr.readLine())  != null) {

                String[] parts= line.split(";");
                sum+= Integer.parseInt(parts[1])* Long.parseLong(parts[2]);
            }
            return sum;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
