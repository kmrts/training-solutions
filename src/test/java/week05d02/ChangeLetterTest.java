package week05d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChangeLetterTest {

    ChangeLetter c= new ChangeLetter();

    @Test
    public void changeLTest(){
        assertEquals("c*k*h*r*", c.changeVowels("cukahara"));
        assertEquals("F*R*M*C* k**ts**", c.changeVowels("FARAMUCI koutsee"));
        assertEquals("*k*l*l*", c.changeVowels("ukulele"));

    }
}
