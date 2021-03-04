package vaccination;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VaccMain {

    public void printMenu() {
        System.out.println("1. Regisztráció\n" +
                "2. Tömeges regisztráció\n" +
                "3. Generálás\n" +
                "4. Oltás\n" +
                "5. Oltás meghiúsulás\n" +
                "6. Riport\n");
    }

    public void chooseFromMenu() {
        System.out.println("Válassz menüpontot: ");
        Scanner sc = new Scanner(System.in);
        try {
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("Regisztráció\n");
                    registrate(sc);
                    break;
                case 2, 3, 4, 5, 6:
                    System.out.println("under const.");
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
            }

        } catch (InputMismatchException ime) {
            System.out.println("Ez nem egy szám!");
            chooseFromMenu();
        }

    }

    private void registrate(Scanner sc) {
        /*

    Ellenőrizzük, a név nem lehet üres
    Ha beírja az irányítószámát, akkor írjuk ki a hozzá tartozó települést
    Ha az irányítószám üres, hibaüzenetet kell kiírni
    Az életkor > 10 és < 150.
    Az e-mail cím legyen formaliag helyes, elegendő, ha legalább 3 karakter, és van benne egy @ karakter
    Az e-mail címét kétszer kell megadni, és másodjára is ugyanazt a címet kell megadni
    A TAJ számot CDV ellenőrzésnek kell alávetni

         */
        Citizen citizen = new Citizen();
//        System.out.println("Kérem a nevet: ");
//        while(!isValidName(sc)){
//            citizen.setName();
//        }
//        String name= sc.nextLine();
//        if(name.isEmpty()){
//
//        }

        System.out.println("Kérem a nevet: ");
        citizen.setName(regName(sc));
        System.out.println("Kérem az irányítószámot: ");
        citizen.setZip(regZipcode(sc));
        System.out.println("Kérem az életkort: ");
        citizen.setAge(regAge(sc));
        System.out.println("Kérem az email-címet: ");
        citizen.setEmail(regEmail(sc));
        System.out.println("Kérem a taj-számot: ");
        citizen.setTaj(regTaj(sc));

        System.out.println(citizen);
    }


    private String regName(Scanner sc) {

        String name = sc.nextLine();
        while (name.isEmpty()) {
            System.out.println("A név üres, kérem újra: ");
            name = sc.nextLine();
        }

        return name;
    }

    private String regZipcode(Scanner sc) {

        String zip = sc.nextLine();
//        if(zip.isEmpty()){
//            System.out.println("Üres, kérem újra: ");
//            regZipcode(sc);
//        }
        while (zip.isEmpty()) {
            System.out.println("Üres, kérem újra: ");
            zip = sc.nextLine();
        }
        // kiir
        return zip;
    }

    private int regAge(Scanner sc) {
        try {
            int age = sc.nextInt();
            sc.nextLine();
            while (age < 10 || age > 150) {
                System.out.println("Min 10, max 150, kérném újra: ");
                age = sc.nextInt();
                sc.nextLine();
            }
            return age;
        } catch (InputMismatchException ime) {
            System.out.println("Ez nem szám!");
            regAge(sc);
        }
        return 0;
    }

    private String regEmail(Scanner sc) {
        String email1 = sc.nextLine();
        while (!isValidEmail(email1)) {
            System.out.println("Nem valid, kérem újra: ");
            email1 = sc.nextLine();
        }
        System.out.println("Kérem az email-címet mégegyszer: ");
        String email2 = sc.nextLine();
        while (!email2.equals(email1)) {
            System.out.println("Nincs egyezés, kérem újra: ");
            email2 = sc.nextLine();
        }
        return email1;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.length() >= 3;
    }

    private String regTaj(Scanner sc) { //check
        String taj = sc.nextLine();
        while (!isCdvValid(taj)) {
            System.out.println("Nem valid, kérem újra: ");
            taj = sc.nextLine();
        }
        return taj;
    }

    private boolean isCdvValid(String s) {
        /*
        A TAJ szám első nyolc számjegyéből a páratlan helyen állókat hárommal,
        a páros helyen állókat héttel szorozzuk, és a szorzatokat összeadjuk.
        Az összeget tízzel elosztva a maradékot tekintjük a kilencedik, azaz CDV kódnak.
         */

        //szám-e
        if (s.length() != 9) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 8; i++) {

            try {
                int actual = Integer.parseInt(String.valueOf(s.charAt(i))); //(s.substring(i, i+1));
                if (i % 2 != 1) {
                    sum += actual * 3;
                } else {
                    sum += actual * 7;
                }

            } catch (IllegalArgumentException e) {
                return false;
            }

        }
        return (sum%10== Integer.parseInt(String.valueOf(s.charAt(8))));

    }

    public static void main(String[] args) {
        VaccMain vm = new VaccMain();
        vm.printMenu();
        vm.chooseFromMenu();
//        System.out.println(vm.isCdvValid("111111110"));
//        System.out.println(vm.isCdvValid("111111117"));


    }
}
