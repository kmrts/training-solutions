package week08d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    public void testRobot() {
        Robot r = new Robot();
        Position p = new Position(-2, 3);

        assertEquals(p.getX(), r.move("FJFBBFFJLLBLBBJFF").getX());
        assertEquals(3, r.getPos().getY());

        assertEquals(p.toString(), r.getPos().toString());

    }

    @Test
    public void testRobotLowerCase() {
        Robot r = new Robot();

        assertEquals(-1, r.move("ffjllbllflljbllb").getX());
        assertEquals(-5, r.getPos().getY());

    }

}