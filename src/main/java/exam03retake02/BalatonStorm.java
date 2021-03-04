package exam03retake02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class BalatonStorm {

    /*
    A https://vmonitor.rsoe.hu/api/mapApi/stations.php címen le lehet tölteni az aktuális balatoni viharjelzéseket.

Írj egy programot, mely kilistázza, hogy hol van vihar! Ábécésorrendbe rendezve!

A BalatonStorm osztály getStationsInStorm() metódusát implementáld! Paraméterként kap egy BufferedReader-t,
és visszaadja az állomások listáját. A fájl a következő formátumú.

[
  {
    "id": 5,
    "allomas": "Siófok (OMSZ)",
    "lat": "46.910647",
    "lng": "18.040237",
    "description": "A közforgalmú MAHART kikötőtől délnyugatra kb. 200 méterre",
    "level": 0,
    "groupId": "BE",
    "stationType": "LED"
  },
  {
    "id": 6,
    "allomas": "Siófok-H. Erzsébet",
    "lat": "46.91567",
    "lng": "18.06600000000003",
    "description": "Hotel Erzsébet szálló tetején.",
    "level": 0,
    "groupId": "BE",
    "stationType": "LED"
  }
]
Azokon az állomásokon van vihar, ahol a level értéke 3.
     */
    private static final int VIHAR= 3;

    public List<String> getStationsInStorm(BufferedReader reader) throws IOException {
        List<String> result= new ArrayList<>();

        String line;
        String tempLine= "";
        while ((line = reader.readLine())  != null) {
            tempLine = selectAndAdd(result, line, tempLine);
        }
        Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
        return result;
    }

    private String selectAndAdd(List<String> result, String line, String tempLine) {
        if(line.contains("allomas")){
            tempLine = line;
        }
        if(line.contains("level")){
            String[] parts= line.split(": ");
            if(Integer.parseInt(parts[1].substring(0, 1))== VIHAR ){
                String[] spl= tempLine.split(": ");
                result.add(spl[1].substring(1, spl[1].length() -2));
            }
        }
        return tempLine;
    }


    public static void main(String[] args) {
        BalatonStorm bs= new BalatonStorm();
        try (BufferedReader reader = Files.newBufferedReader(Path.of("src", "test", "resources", "exam03retake02", "storm.json"))) {
            System.out.println(bs.getStationsInStorm(reader) );
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}
