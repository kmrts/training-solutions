package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        Time time= new Time(12, 50,2);
        System.out.println(time.getInMinutes());
        System.out.println(time.getInSeconds());
    }
}
