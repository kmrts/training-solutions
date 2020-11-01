package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Kérlek adj meg egy egész számot: ");
        int first= scanner.nextInt();
        System.out.println("Kérlek adj egy másik egész számot: ");
        int second= scanner.nextInt();

        System.out.println(first + "+" + second);
        System.out.println(first+ second);
    }
}
