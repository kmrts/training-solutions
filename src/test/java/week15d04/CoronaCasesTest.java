package week15d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class CoronaCasesTest {

    @Test
    void readData() {
        CoronaCases cc= new CoronaCases();
        cc.readData(Path.of("data.csv"));
//        System.out.println(cc.getCaseList());

        System.out.println(cc.sortAndThreeMax());
    }
}