package week14d05;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class HachikoWordTest {

    @Test
    void testCountWords(){
        HachikoWord hw= new HachikoWord();
        hw.countWords(Path.of("hachiko.srt"), "Hachiko", "haza", "pályaudvar", "jó",
                "Hachi", "kutya", "macsk", "egér", "java");

        System.out.println(hw.getWordCount());
    }

}