package week09d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testPerson() {
        Person pe = new Person("Jekk", 19);
        pe.setPresent();
        assertNotEquals(null, pe.getPresent());  //not null, not TOY
        assertNotEquals(Present.TOY, pe.getPresent());  //not null, not TOY
        assertEquals(20, pe.getAge() + 1);

        for (int i = 1; i < 25; i++) {
            pe.setPresent();
            System.out.println(pe.getPresent());

        }
    }

    @Test
    public void testPersonBelow14() {
        Person p1 = new Person("Josee", 14);

        for (int i = 1; i < 25; i++) {
            p1.setPresent();
            System.out.println(p1.getPresent());
        }
    }

}