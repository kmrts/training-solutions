package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Adj meg egy számot: ");
        int number= scanner.nextInt();

        System.out.println(number+ " osztható-e 3-mal: " + (number%3==0) );
    }
}
