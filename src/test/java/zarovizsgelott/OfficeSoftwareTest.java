package zarovizsgelott;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OfficeSoftwareTest {

    @Test
    void increasePrice() {
        OfficeSoftware sw= new OfficeSoftware("writer", 1000);
        sw.increasePrice();
//        System.out.println(sw.getPrice());

        assertEquals(1050, sw.getPrice());
    }
}