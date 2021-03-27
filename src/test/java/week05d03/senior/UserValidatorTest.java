package week05d03.senior;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {

    @Test
    public void testValidate(){
        UserValidator uv= new UserValidator();

        List<User> users0= null;
        List<User> users1= List.of(new User("Paul", 20), new User("Ditte", 57));
        List<User> users2= List.of(new User("Paul", 121), new User("Ditte", 57));
        List<User> users3= new ArrayList<>();
        users3.add(new User("Paul", 54));
        users3.add(null);

        assertTrue(uv.validate(users1));

        assertThrows(IllegalArgumentException.class, ()-> uv.validate(users0));
        assertThrows(IllegalArgumentException.class, ()-> uv.validate(users2));
//        assertThrows(IllegalArgumentException.class, ()-> uv.validate(users3));
        assertThrows(NullPointerException.class, ()-> uv.validate(users3));

    }

}