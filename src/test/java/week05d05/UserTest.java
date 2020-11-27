package week05d05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserTest {

    @Test
    public void testUser() {
        User u = new User("Steven", "Taylor", "staylor@hello.com");
        assertEquals("Steven Taylor", u.getFullName());
        assertEquals("staylor@hello.com", u.getEmail());
    }

    @Test
    public void testWrongEmailAdr() {
//        User u= new User("Stan","Taylor", "staylorhello.com");
        assertThrows(IllegalArgumentException.class, () ->
                {
                    new User("Stan", "Taylor", "staylorhello.com");
                }
        );
        assertThrows(IllegalArgumentException.class, () ->
                {
                    new User("Sven", "Gaynor", "sven@gaynorcom");
                }
        );
    }
}
