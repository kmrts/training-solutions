package numbers;

import java.util.Scanner;

public class CircleMain {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Kör átmérője: ");
 //       new Circle(Integer.parseInt(s.nextLine())).perimeter();
        Circle c1= new Circle(Integer.parseInt(s.nextLine()));
        System.out.println("A kör kerülete: "+ c1.perimeter()+ " területe: "+ c1.area());
        System.out.println("Kör átmérője: ");
        Circle c2= new Circle(Integer.parseInt(s.nextLine()));
        System.out.println("A kör kerülete: "+ c2.perimeter()+ " területe: "+ c2.area());


    }
}
