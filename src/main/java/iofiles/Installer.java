package iofiles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Installer {
   /*
   egyetlen install() metódussal, mely paraméterként a telepítési mappát kapja meg String-ként.
   A megadott mappán belülre másold át a classpathról az install mappában lévő fájlokat és mappákat az install mappából!
   Az install.txt fájlban a / jelre végződő sorok mappákat jelölnek, ezeket létre kell hoznod,
   mielőtt fájlokat másolnál bele.
   Az esetleges sikertelen telepítésből visszamaradt fájlokat mindig írd felül!
   Ha a paraméterül kapott mappa nem létezik vagy nem is mappa, dobj IllegalArgumentException kivételt!
    */
    public void install(String folder){
        List<String> list =readTxtFile("install.txt");

        for(String item: list){
            if(item.endsWith("/")){
                Path path= Path.of(folder+ "/"+ item);
                try {
                    Files.createDirectory(path);
                } catch (IOException e) {
                    throw new IllegalStateException("cannot create directory", e);
                }
            }else{

                int index = item.indexOf("/");
                String subfolder= item.substring(0, index+1);
                String fileName= item.substring(index+1);
                try {
                    Files.copy(Path.of("src/main/resources/install/"+item), Path.of(folder+"/"+subfolder), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    throw new IllegalStateException("cannot copy file", e);
                }
            }
        }
    }

    public List<String> readTxtFile(String fileName){
        List<String> list= new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Installer.class.getResourceAsStream("/"+ fileName)))) {
            String line;

            while ( (line= br.readLine()) !=null){
                list.add(line);
                System.out.println(line);
            }
        }catch (IOException ex){
            throw new IllegalStateException("cannot read file", ex);
        }
        return list;
    }
}
