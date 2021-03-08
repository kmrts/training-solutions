package vaccination;

import java.time.LocalDate;

public class Vaccine {
    private int number;
    private LocalDate last;

    public Vaccine(int number, LocalDate last) {
        this.number = number;
        this.last = last;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getLast() {
        return last;
    }
}
