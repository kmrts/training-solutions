package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    Map<String, Integer> owls= new HashMap<>();

    public void readFromFile(BufferedReader br) throws IOException {
        String line;

        while ((line = br.readLine())  != null) {
            String[] spl= line.split("=");

            owls.put(spl[0], Integer.parseInt(spl[1]));
        }
//        System.out.println(owls);
    }

    public int getNumberOfOwls(String s) {
        if( !owls.containsKey(s)){
            throw new IllegalArgumentException("no such county");
        }
        int result= owls.get(s);
        return result;
    }
    /*
    A OwlCounter oszály egy Map<String, Integer> attribútumban tárolja, hogy melyik megyében mennyi baglyot számoltak a madárszámlálók. 
    A readFromFile() metódussal (paraméterezése, visszatérési értéke kiderül a tesztesetből) töltsd be az értékeket egy fájlból! 
    A fájl formátuma a következő:
Bács-Kiskun=1000
Baranya=1050
Békés=980
Borsod-Abaúj-Zemplén=600
A getNumberOfOwls() metódus adja vissza a baglyok számát a paraméterként átadott megyében!
     */
    
}
