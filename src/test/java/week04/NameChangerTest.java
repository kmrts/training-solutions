package week04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NameChangerTest {

    @Test
    void createNCTest(){
        NameChanger nc= new NameChanger("Doe Joe");
        assertEquals("Doe Joe", nc.getFullName());
//        assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        //vagy
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> new NameChanger(""));
        assertEquals("Illegal name:", iae.getMessage());

    }
    @Test
    void testChanger() {
        NameChanger nc= new NameChanger("Kovács Joe");
        nc.changeFirstName("John");
        assertEquals("Kovács John" , nc.getFullName());
    }

    @Test
    public void isTheSameTest(){
        NameChanger nc= new NameChanger("Kovács Joe");
//        assertEquals(true, nc.isTheSame("Kovács Joe"));
        assertTrue(nc.isTheSame("Kovács Joe"));
    }
}
