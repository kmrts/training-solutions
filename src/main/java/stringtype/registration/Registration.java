package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        UserValidator userv= new UserValidator();

        Scanner s = new Scanner(System.in);
        System.out.println("Felhasználónév: ");
        String username= s.nextLine();
        System.out.println("A felh.név "+ (userv.isValidUsername(username)? "helyes":"helytelen") );

        System.out.println("Jelszó: ");
        String pw1= s.nextLine();
        System.out.println("Jelszó még1x: ");
        String pw2= s.nextLine();
        System.out.println("A jelszó "+ (userv.isValidPassword(pw1, pw2)? "helyes":"helytelen") );

        System.out.println("Email-cím: ");
        String email= s.nextLine();
        System.out.println("Az email-cím "+ (userv.isValidEmail(email)? "helyes":"helytelen") );        ;
    }
}
