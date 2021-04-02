package week05d05.senior;

import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {

    @Test
    public void testSong(){
        Song s1= new Song("Cím", 320, "Band");
//        System.out.println(s1);


        assertEquals("Band - Cím, length: 320", s1.toString() );

        assertThrows(IllegalArgumentException.class, () -> new Song("", 200, "Előa."));

    }

}