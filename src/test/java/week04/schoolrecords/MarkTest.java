package week04.schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class MarkTest {

    public static final Subject SUBJECT = new Subject("matematika");
    public static final Tutor TUTOR = new Tutor("Nagy Lilla", Arrays.asList(SUBJECT));


    @Test
    public void nullParameterShouldThrowException() throws NullPointerException {
        Exception ex = assertThrows(NullPointerException.class, () -> new Mark(MarkType.A, null, TUTOR));
        assertEquals("Both subject and tutor must be provided!", ex.getMessage());
    }

    @Test
    public void testCreate() {
        Mark mark = new Mark(MarkType.A, SUBJECT, TUTOR);
        assertEquals(MarkType.A, mark.getMarkType());
        assertEquals(SUBJECT, mark.getSubject());
        assertEquals(TUTOR, mark.getTutor());
        assertEquals("excellent(5)", mark.toString());
    }

    @Test
    public void testConstr(){
        Mark mark =new Mark(MarkType.valueOf("B"), SUBJECT, TUTOR); //4 és "4" nem jó
        assertEquals(4, mark.getMarkType().getValue());

        Mark mark1 = new Mark("4", SUBJECT, TUTOR);
        assertEquals(4, mark1.getMarkType().getValue());
        Mark mark2 = new Mark("2", SUBJECT, TUTOR);
        assertEquals("close fail", mark2.getMarkType().getDescription());

        Mark mark3 = new Mark("F", SUBJECT, TUTOR);
        assertEquals("fail", mark3.getMarkType().getDescription());

        Mark mark4 = new Mark("más egyéb", SUBJECT, TUTOR);
        assertEquals(1, mark4.getMarkType().getValue());

    }
}
