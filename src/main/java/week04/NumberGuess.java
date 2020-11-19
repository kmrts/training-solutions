package week04;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

    public static void main(String[] args) {
        int limit= 1_000;
        System.out.println("gondoltam egy számra 1 és "+limit +" között, találd ki!");

        Random rnd= new Random();
        int number= rnd.nextInt(limit)+1;
//        System.out.println(number);
        int guess= 0;
        int step= 1;
        Scanner s= new Scanner(System.in);
        while(guess!= number) {
            System.out.println("Kérem a tipped: ");
            guess= s.nextInt();
//            guess= Integer.parseInt(s.nextLine()); // javasoltabb

            if(number> guess){
                System.out.println(guess+ "-nál/nél nagyobb számra gondoltam");
            }  //else if lehetne
            if(number< guess){
                System.out.println(guess+ "-nál/nél kisebb számra gondoltam");
            }
            if(number==guess){
                System.out.println("Talált, süllyedt! "+ step +" lépésben");
            }
            step++;
        }

    }
}
