package statements;

import java.util.Scanner;

public class InvestmentMain {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        System.out.println("Befektetendő összeg: ");
        int amount= scanner.nextInt();
        System.out.println("Kamatláb: ");
        int rate= scanner.nextInt();

        Investment investment= new Investment(amount, rate);

        System.out.println("A befektetés összege: "+ investment.getFund());
        System.out.println("A kamatláb: "+ investment.getInterestRate());

        System.out.println("Tőke: "+ investment.getFund() +" hozama 50 napra: "+ investment.getYield(50));

        System.out.println("Kivett összeg 80 nap után: "+ investment.close(80));
        //System.out.println("ktg "+ investment.getFund()*0.3/100);
        System.out.println("Kivett összeg 90 nap után: "+ investment.close(90));

    }
}
