package ioreadstring.names;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path myFile;
    private List<Human> humans= new ArrayList<>();

    public FileManager(String path) {
        this.myFile = Path.of(path);
    }

    public Path getMyFile() {
        return myFile;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void readFromFile(){
        List<String> names= null;
        try {
            names= Files.readAllLines(myFile);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
        for(String name: names){
            String[] wholeName =name.split(" ");
            humans.add(new Human(wholeName[0], wholeName[1]) );
        }
    }
}
