package week12d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GradeRunnerTest {
    @Test
    public void testRoundGrades(){
        GradeRunner gr= new GradeRunner();
        int[] sample= new int[]{45, 67, 81, 79, 35};
        int[] expected= new int[]{45, 67, 81, 80, 35};

//        assertEquals(expected.toString(), gr.roundGrades(sample));
        assertEquals(67, gr.roundGrades(sample)[1]);
        assertEquals(80, gr.roundGrades(sample)[3]);
        assertEquals(81, gr.roundGrades(sample)[2]);
        assertEquals(35, gr.roundGrades(sample)[4]);
    }

}