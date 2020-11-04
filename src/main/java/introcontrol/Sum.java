package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        int sum= 0;
        for(int i=1; i<=5; i++){
            System.out.println("kérem a köv számot: ");
            sum+= s.nextInt();
        }
        System.out.println("A számok összege: "+ sum);
    }
}
