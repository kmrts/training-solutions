package week11d03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    public void testWordsWithCar(){
        WordFilter wf= new WordFilter();

        assertEquals(List.of("macska", "cickány"), wf.wordsWithChar(List.of("egér", "macska", "kutya", "cickány"), 'c') );
        assertEquals(List.of("cickány"), wf.wordsWithChar(List.of("egér", "macska", "kutya", "cickány"), 'á') ); //"[cickány]" nem jó, string, nem lista
        assertEquals( List.of(), wf.wordsWithChar(List.of("egér", "macska", "kutya", "cickány"), 'b') );  // null helyett [] üres lista

    }

}