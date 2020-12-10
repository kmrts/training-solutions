package week07d04;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class LabTest {
    @Test
    public void testLab(){
        Lab l= new Lab("lecke1");
        l.complete(LocalDateTime.now());
        assertEquals(true, l.isCompleted());

        assertTrue(new Lab("lecke2", LocalDateTime.of(2020, 12, 10, 17, 10)).isCompleted() );
        assertEquals("title: lecke3, completed: true, completedAt: 2020-12-10T17:25",
                new Lab("lecke3", LocalDateTime.of(2020, 12, 10, 17, 25)).toString());

    }

}