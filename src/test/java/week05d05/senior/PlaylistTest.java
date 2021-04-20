package week05d05.senior;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlaylistTest {

    @Test
    void findByLengthGreaterThan() {
        Song s1= new Song("dalcím", 320, "Banda");
        Song s2= new Song("Rövidebb dal", 250, "Banda2");
        Song s3= new Song("Extended hit", 375, "Akárki");
        List<Song> list= List.of(s1, s2, s3);

        Playlist playlist= new Playlist(list);

        System.out.println(playlist.toString());

        assertEquals(2, playlist.findByLengthGreaterThan(5).size());
        assertEquals("Extended hit", playlist.findByLengthGreaterThan(5).get(1).getName());


    }
}