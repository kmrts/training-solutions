package week10d01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevationTest() {
        Hiking h= new Hiking();

        assertEquals(13.0, h.getPlusElevation(List.of(10.0,20.,15.,18.)) );
        assertEquals(0.0, h.getPlusElevation(List.of(0.0) ));
        assertEquals(0.0, h.getPlusElevation(List.of() ));

        assertThrows(IllegalArgumentException.class, () -> h.getPlusElevation(null) ) ;
    }
}