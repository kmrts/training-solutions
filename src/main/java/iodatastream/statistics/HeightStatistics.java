package iodatastream.statistics;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class HeightStatistics {
    /*
    készíts egy HeightStatistics osztályt, bele pedig egy saveHeights() metódust.
    A metódus egy kosárcsapat tagjainak testmagasságát kapja meg List<Integer> típusú paraméterben.
    A paraméterben kapott Path objektumként reprezentált fájlba menti először a lista méretét, majd egyenként a lista elemeit.
     */
    public void saveHeights(List<Integer> heights, Path file){
        try (DataOutputStream dost = new DataOutputStream(new BufferedOutputStream(Files.newOutputStream(file)))) {
            dost.writeInt( heights.size());
            for(int h: heights){
                dost.writeInt(h);
            }

        }
        catch (IOException e){
            throw new IllegalStateException("cannot write file", e);
        }

    }
}
