package iozip.names;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EmployeeFileManager {
    /*
    készíts egy EmployeeFileManager osztályt!
    Egyetlen metódusa van, a saveEmployees(), mely a paraméterként kapott Path által reprezentált zip fájlba
    létrehoz egy names.dat nevű bináris fájlt, és a szintén paraméterként kapott névlista tartalmát beleírja.
     */
    public void saveEmployees(Path filepath, List<String> names){

        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(Files.newOutputStream(filepath)))) {
            zos.putNextEntry(new ZipEntry("names.dat"));
            for(String name: names){
                zos.write(name.getBytes());  //.getBytes()
            }

        }catch (IOException ioe){
            throw new IllegalStateException("can not write file", ioe);
        }
    }
}
