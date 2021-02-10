package week15d02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QuizHandlerTest {

    @Test
    void quesFromTheme() {
        QuizHandler qh= new QuizHandler();
        qh.readQuizItems(Path.of("kerdesek.txt") );
        System.out.println(qh.quesFromTheme("tortenelem"));
    }

    @Test
    void randQuestion() {
        QuizHandler qh= new QuizHandler();
        qh.readQuizItems(Path.of("kerdesek.txt") );
        Quiz q= qh.randQuestion();

        System.out.println(q.getQuestion());
        System.out.println(q.getAnswer());
        System.out.println(q.getPoint());
        System.out.println(q.getTheme());
    }

    @Test
    void questionsByThemes() {
        QuizHandler qh= new QuizHandler();
        qh.readQuizItems(Path.of("kerdesek.txt") );

        Map<String, List<Quiz>> resMap= qh.questionsByThemes();

        System.out.println( resMap);
        System.out.println( resMap.size());
        System.out.println( resMap.get("vmi"));

        System.out.println( qh.questionsByThemes().get("magyar"));
        System.out.println( qh.questionsByThemes().get("tortenelem").size());
        System.out.println( qh.questionsByThemes().get("matematika").size());

        assertEquals(18, resMap.get("foldrajz").size());

        assertEquals(57, qh.getQuizList().size());

        int sum= resMap.get("kemia").size()+ resMap.get("magyar").size() + resMap.get("tortenelem").size()
                + resMap.get("foldrajz").size()+ resMap.get("matematika").size();
        assertEquals(57, sum);
    }

    @Test
    void maxSumPointedTheme() {
        QuizHandler qh= new QuizHandler();
        qh.readQuizItems(Path.of("kerdesek.txt") );

        System.out.println(qh.maxSumPointedTheme());
    }
}