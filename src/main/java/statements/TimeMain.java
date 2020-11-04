package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("1. időpont, óra: ");
        int hour= scanner.nextInt();
        System.out.println("1. időpont, perc: ");
        int minute= scanner.nextInt();
        System.out.println("1. időpont, mp: ");
        int second= scanner.nextInt();

        Time time1= new Time(hour, minute, second);

        System.out.println("2. időpont, óra: ");
        hour= scanner.nextInt();
        System.out.println("2. időpont, perc: ");
        minute= scanner.nextInt();
        System.out.println("2. időpont, mp: ");
        second= scanner.nextInt();

        Time time2= new Time(hour, minute, second);

        System.out.println("Az első időpont "+ time1.toString()+" = " +time1.getInMinutes()+ " perc");
        System.out.println("A második időpont "+ time2.toString() +" = "+ time2.getInSeconds()+ " másodperc");
        System.out.println("Az első korábbi, mint a második: "+ time1.earlierThan(time2));
    }
}
