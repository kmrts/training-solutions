package week13d03;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class TeacherLessonTest {
    @Test
    public void testCountLessons(){
        TeacherLesson tl= new TeacherLesson();
        Path path= Path.of("beosztas.txt");

        assertEquals(22, tl.countTeachersLessonsPerWeek(path, "Csincsilla Csilla") );
        assertEquals(25, tl.countTeachersLessonsPerWeek(path, "Hermelin Herman") );
        assertEquals(4*4+ 3+ 5, tl.countTeachersLessonsPerWeek(path, "Kutya Kuniginda") );

        assertEquals(0, tl.countTeachersLessonsPerWeek(path, "Nyérc Hermina") );
    }

}