package week15d05.junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MaxBattle {
    /*
    Adott egy fájl a következő címen:
    https://raw.githubusercontent.com/TheMLGuy/Game-of-Thrones-Dataset/master/battles.csv
    Melyik ház vett részt a legtöbb csatában?

    name,year,battle_number,attacker_king,defender_king,
attacker_1,attacker_2,attacker_3,attacker_4,
defender_1,defender_2,defender_3,defender_4,
attacker_outcome,battle_type,major_death,major_capture,attacker_size,defender_size,attacker_commander,
defender_commander,summer,location,region,note

5 -8, 9- 12
     */

    private Map<String, Integer> kingMap= new HashMap<>();

    public Map<String, Integer> getKingMap() {
        return new HashMap<>(kingMap);
    }

    public void readData(Path path){
        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                convertLine(line);
            }
        } catch (IOException ioe) {
            throw new IllegalArgumentException("cannot read file", ioe);
        }
    }
    private void convertLine(String line){
        line= arrangeLine(line);
        String[] temp= line.split("::");

        for(int i=5; i<=12; i++){
            putToMap(temp[i]);
        }

    }
    private String arrangeLine(String line) {
        line = line.replace(", ", ";change;");
        line = line.replace(",", "::");
        line = line.replace(";change;", ", ");
        return line;
    }
    private void putToMap(String str){
        if(!str.isEmpty()){
//            System.out.println(str);
            int actual= 0;
            if(kingMap.containsKey(str)){
                actual= kingMap.get(str);

            }
            kingMap.put(str, actual+1);
        }

    }

    public String findMax(){

        int max= 0;
        String result= null;
        for(Map.Entry<String, Integer> entry: kingMap.entrySet()){
            if(result==null || entry.getValue() >max){
                max= entry.getValue();
                result= entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxBattle mb= new MaxBattle();
        mb.readData(Path.of("battles.csv"));
        System.out.println(mb.getKingMap());
        System.out.println(mb.findMax());
    }
}
