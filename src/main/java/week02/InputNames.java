package week02;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] names = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Kérem a "+ i+1 +". nevet: ");
            names[i] = s.nextLine();
        }
/*
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1 + ". elem: " + names[i]);
        }

 */
        int i= 0;
        for (String item : names
        ) {
            System.out.println(i + 1 + ". elem: " + names[i]);
            i++;
        }
    }

}
