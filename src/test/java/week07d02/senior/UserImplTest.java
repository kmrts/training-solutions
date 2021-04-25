package week07d02.senior;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest {

    @Test
    void testUserImpl(){
        User user= new UserImpl("feri", "Ferenc", "Orbit");

        assertEquals("feri", user.getUsername());
        assertEquals("Ferenc Orbit", user.getFullName());

//        User user1= user.of("baelah", "Béla", "Taylor");
//        assertEquals("Taylor", user1.getLastName());
//        assertEquals("Béla Taylor", user1.getFullName());

        User user1= User.of("baelah", "Béla", "Taylor");
        assertEquals("Taylor", user1.getLastName());
        assertEquals("Béla Taylor", user1.getFullName());
    }

}