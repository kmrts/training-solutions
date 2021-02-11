package week15d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CoronaCasesTest {

    @Test
    void readData() {
        CoronaCases cc= new CoronaCases("Hungary");
        cc.readData(Path.of("data.csv"));
//        System.out.println(cc.getCaseList());

        System.out.printf(cc.sortAndThreeMax());
        assertEquals(3, cc.getThree().size());
        assertEquals(39170, cc.getThree().get(0).getCaseOfWeek());

        CoronaCases cc2= new CoronaCases("Cyprus");
        cc2.readData(Path.of("data.csv"));
        System.out.printf(cc2.sortAndThreeMax());

        CoronaCases cc3= new CoronaCases("Curaçao");
        cc3.readData(Path.of("data.csv"));
        System.out.printf(cc3.sortAndThreeMax());
    }
}