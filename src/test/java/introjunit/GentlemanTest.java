package introjunit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GentlemanTest {

    @Test   /////
    public void testCreate(){
        //Given
        String name= "Ben";

        //When
        String resName= new Gentleman().sayHello("Ben");

        //Then
        assertEquals("Hello Ben", resName);
    }

}