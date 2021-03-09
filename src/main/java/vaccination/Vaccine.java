package vaccination;

import java.time.LocalDate;

public class Vaccine {
    private boolean vaccined;
    private int number;
    private LocalDate last;

//    public Vaccine(int number, LocalDate last) {
//        this.number = number;
//        this.last = last;
//    }

    public Vaccine(boolean isVaccined, int number, LocalDate last) {
        this.vaccined = isVaccined;
        this.number = number;
        this.last = last;
    }

    public boolean isVaccined() {
        return vaccined;
    }

    public int getNumber() {
        return number;
    }

    public LocalDate getLast() {
        return last;
    }
}
