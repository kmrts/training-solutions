package week15d02;

public class Quiz {
    private String question;
    private String answer;
    private String point;
    private String theme;

    public Quiz(String question, String answer, String point, String theme) {
        this.question = question;
        this.answer = answer;
        this.point = point;
        this.theme = theme;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getPoint() {
        return point;
    }

    public String getTheme() {
        return theme;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", point='" + point + '\'' +
                ", theme='" + theme + '\'' +
                '}';
    }
}
