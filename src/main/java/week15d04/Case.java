package week15d04;

public class Case {
    private String week;
    private int casePerWeek;

    public Case(String week, int casePerWeek) {
        this.week = week;
        this.casePerWeek = casePerWeek;
    }

    public String getWeek() {
        return week;
    }

    public int getCasePerWeek() {
        return casePerWeek;
    }

    @Override
    public String toString() {
        return "Case{" +
                "week='" + week + '\'' +
                ", casePerWeek=" + casePerWeek +
                '}';
    }
}
