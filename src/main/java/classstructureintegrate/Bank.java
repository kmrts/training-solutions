package classstructureintegrate;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        System.out.println("Az első számla száma: ");
        String aNumber= scanner.nextLine();
        System.out.println("Az első számla tulaja: ");
        String owner= scanner.nextLine();
        System.out.println("Az első számla egyenlege: ");
        int balance= scanner.nextInt();

        scanner.nextLine();
        BankAccount account1= new BankAccount(aNumber, owner, balance);

        System.out.println("A 2. számla száma: ");
        aNumber= scanner.nextLine();
        System.out.println("A 2. számla tulaja: ");
        owner= scanner.nextLine();
        System.out.println("A 2. számla egyenlege: ");
        balance= scanner.nextInt();
        BankAccount account2= new BankAccount(aNumber, owner, balance);

        System.out.println(account1.getInfo());
        System.out.println(account2.getInfo());
        account1.deposit(200);
        System.out.println(account1.getBalance());
        account1.withdraw(100);
        System.out.println(account1.getBalance());
        account1.transfer(account2, 150);
        System.out.println("1. "+ account1.getBalance());
        System.out.println("2. "+ account2.getBalance());

    }
}
