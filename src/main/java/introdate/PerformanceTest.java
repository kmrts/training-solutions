package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class PerformanceTest {
    public static void main(String[] args) {

        Performance perf= new Performance(LocalDate.of(1985,05,05),
                "Duran Duran", LocalTime.of(20,30), LocalTime.of(22,0));
        System.out.println(perf.getInfo());
    }
}
