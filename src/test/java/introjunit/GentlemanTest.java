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
//    org.junit.ComparisonFailure:
//    Expected :Hello Ben
//    Actual   :Helle Ben

//    org.junit.ComparisonFailure:
//    Expected :Helle Ben
//    Actual   :Hello Ben

//    75%
    @Test
    public void testNull(){
        //Given
        String name= null;

        //When
        String resName= new Gentleman().sayHello(null);

        //Then
        assertEquals("Hello Anonymous", resName);
    }
//    100 % lefed.
}