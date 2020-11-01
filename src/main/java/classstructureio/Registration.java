package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Kérem a neved: ");
        String name = scanner.nextLine();
        System.out.println("Kérem az email-címed: ");
        String emailAdress = scanner.nextLine();

        System.out.println("Az alábbi adatokkal regisztráltál:");
        System.out.println("Név: " + name);
        System.out.println("Email-cím: " + emailAdress);
    }
}
