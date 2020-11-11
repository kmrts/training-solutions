package numbers;

import java.util.Scanner;

public class MathOperations {

    public static void main(String[] args) {

        String a= "(25+4) / (9-5) - 3.6";

        double sol= (25.0+4) / (27-5) +5 - 1.2;  // 25 nem jó

//        System.out.println(sol);

        System.out.println("Mennyi az alábbi kif. értéke: "+ a+ " ?");
        System.out.println("Négy tizedes pontossággal. Tizedesvessző: ,");
        Scanner s=new Scanner(System.in);
        double useSol=s.nextDouble();

        if(Math.abs(sol - useSol) < 0.0001){
            System.out.println("Jó megoldás");
        }else{
            System.out.println("Helytelen megoldás");
        }





    }
}
