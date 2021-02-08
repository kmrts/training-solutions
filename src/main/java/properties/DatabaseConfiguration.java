package properties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DatabaseConfiguration {
    /*
    mely properties állományból betölti az adatbázis beállításokat, majd le lehet ezeket kérdezni.
    Létre lehet hozni paraméter nélküli konstruktorral, ekkor a classpath-ról tölti be a properties állományt.
    Van egy File paramétert váró konstruktora is, melyet megadva a beállításokat a paraméterként megadott fájlból tölti be.

Megvalósítási javaslatok
Figyelj a karakterkódolásra. IDEA-ban, hogy a properties fájlt UTF-8 kódolással hozza létre, át kell állítani,
File / Settings / Editor / File Encodings ablakon a "Default encoding for properties files" értékét kell UTF-8-ra állítani.
A karakterkódolás konstans értékként legyen megadva.

A betöltés a konstruktorban történjen. Érdemes felvenni egy Properties típusú attribútumot.
A getHost(), getPort() és getSchema() metódusok ezt hívják.
     */
    private Properties p= new Properties();

    public DatabaseConfiguration() {

        try(InputStream is= DatabaseConfiguration.class.getResourceAsStream("/db.properties") ){  // kell a /
             p.load(is);
        }catch (IOException e){
            throw new IllegalArgumentException("can not load file", e);
        }

    }

    public DatabaseConfiguration(File file) {
        try (InputStreamReader isr= new InputStreamReader(new FileInputStream(file), "UTF-8")) {  //BufferedReader brd ...
            p.load(isr); //InputStream is= new FileInputStream(file)
        }catch (IOException ioe){
            throw new IllegalArgumentException("Cannot read file", ioe);
        }
    }

    public String getHost(){
        return p.getProperty("db.host");
    }
    public int getPort(){
        return Integer.valueOf( p.getProperty("db.port") );

    }
    public String getSchema(){
        return p.getProperty("db.schema");
    }

}
