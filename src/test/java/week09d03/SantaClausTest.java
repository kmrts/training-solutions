package week09d03;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SantaClausTest {
    @Test
    public void testSantaClaus(){
        List<Person> peo= new ArrayList<>();
        peo.add(new Person("Abi", 9 ));
        peo.add(new Person("Béla", 39 ));
        peo.add(new Person("Eddy", 14 ));

        SantaClaus sc= new SantaClaus(peo);
        sc.getThroughChimneys();

        assertEquals("Abi", peo.get(0).getName());
        assertEquals(3, peo.size());
        assertEquals(null, peo.get(1).getPresent());
        assertEquals(14, peo.get(2).getAge());
    }

}