package week15d04;

public class Case {
    private String week;
    private int caseOfWeek;

    public Case(String week, int caseOfWeek) {
        this.week = week;
        this.caseOfWeek = caseOfWeek;
    }

    public String getWeek() {
        return week;
    }

    public int getCaseOfWeek() {
        return caseOfWeek;
    }

    @Override
    public String toString() {
        return "Case{" +
                "week='" + week + '\'' +
                ", caseOfWeek=" + caseOfWeek +
                '}';
    }
}
