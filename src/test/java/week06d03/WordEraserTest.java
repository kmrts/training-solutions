package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordEraserTest {

    WordEraser we= new WordEraser();

    @Test
    public void testWordEraser(){

        String words= "eb kutya zseb macska eb ebéd eb egér";
        assertEquals("kutya zseb macska ebéd egér", we.eraseWord(words, "eb"));
    }
    @Test
    public void testTrim(){

        String words= "teke  eke aka   eke  tika ";
        assertEquals("teke aka tika", we.eraseWord(words, "eke"));
    }
    @Test
    public void testEmpty(){

        String words= "";
        assertEquals("", we.eraseWord(words, ""));
    }
    @Test
    public void testIfNull(){

        String words= null;
        assertThrows(NullPointerException.class, () -> we.eraseWord(words, "valami") );
    }
    @Test
    public void testIfNullWord(){

        String words= "ez az amaz";
        assertEquals("ez az amaz", we.eraseWord(words, null));
//        assertThrows(NullPointerException.class, () -> we.eraseWord(words, null) );
    }

}