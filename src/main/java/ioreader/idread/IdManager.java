package ioreader.idread;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class IdManager {
    /*
    Ez az osztály felelős az idnumbers.txt (kitalált) személyi igazolvány számokat tartalmazó szöveges állomány feldolgozásáért.
    A readIdsFromFile() metódus megkap egy fájlnevet, és annak sorait tárolja el az List<String> ids listában.
     */
    private List<String> ids= new ArrayList<>();

    public List<String> getIds() {
//        return ids;
        return new ArrayList<>(ids);  //
    }

    public void readIdsFromFile(String filename){

        Path file= Path.of("src/main/resources/" +filename);  //
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while( (line= reader.readLine())!= null){ // reader.readLine() !=null
                ids.add(line);        //ids.add( reader.readLine());
            }
        }catch (IOException ioe){
            throw new IllegalStateException("can not read file", ioe);
        }
    }
}
