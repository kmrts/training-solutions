package ioreadwritebytes.temperatures;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemperaturesReader {

    public Temperatures readTemperatures(String pathString){
        Path file= Path.of(pathString);
        byte[] bytes; // =new byte[]{}
        try {
            bytes= Files.readAllBytes(file);
        } catch (IOException e) {
            throw new IllegalStateException("can not read file", e);
        }
        return new Temperatures(bytes);
    }
}
