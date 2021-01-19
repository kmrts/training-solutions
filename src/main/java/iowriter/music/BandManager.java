package iowriter.music;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class BandManager {
    /*
    Ebben a fájl olvasását és írását is gyakorolhatod. Adott a bands_and_years.txt állomány,
    melyben zenekarok nevét és alapítási évét találod.
    Készíts egy metódust melynek a paramétere egy fájl és egy évszám!
    Ez a metódus ki fogja írni a fájlba az évszámnál régebben alakult zenekarokat.
    Megoldási javaslat, hogy készíts egy privát metódust, ami kigyűjti ezeket a zenekarokat egy listába.
    Minden zenekart egy Band objektum reprezentál, melynek attribútumai a név és az évszám.
     */
    private List<Band> bands= new ArrayList<>(); ////

    public void writeBandsBefore(Path fileToWr, int year) {
        try (BufferedWriter bw= Files.newBufferedWriter(fileToWr) ){  //, StandardOpenOption.APPEND
//            readBandsFromFile(Path.of("src/main/resources/" + "bands_and_years.txt" ));
            for(Band item: bands){

                if(item.getYear() < year){
                    bw.write(item.getName() +" " + item.getYear() +"\n");  //
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException("can not write file", e);
        }


    }

    public void readBandsFromFile(Path file) {

        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                String name= line.substring(0, line.indexOf(";"));
                String yearStr= line.substring(line.indexOf(";")+1 );
                int year= Integer.parseInt(yearStr);
                bands.add(new Band(name, year));
            }
        } catch (IOException e) {
            throw new IllegalStateException("cannot read file", e);
        }
    }

    public static void main(String[] args) {
        BandManager bm= new BandManager();
        bm.readBandsFromFile( Path.of("bands_and_years.txt") ); //"src/main/resources/" +
// nem src... resources-be hanem gyökérbe
        bm.writeBandsBefore(Path.of("out.txt"), 1990);
    }

}
