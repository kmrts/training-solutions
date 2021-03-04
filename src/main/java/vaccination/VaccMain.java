package vaccination;

import java.util.InputMismatchException;
import java.util.Scanner;

public class VaccMain {

    public void printMenu(){
        System.out.println("1. Regisztráció\n" +
                "2. Tömeges regisztráció\n" +
                "3. Generálás\n" +
                "4. Oltás\n" +
                "5. Oltás meghiúsulás\n" +
                "6. Riport");

        Scanner sc= new Scanner(System.in);
        System.out.println("Válassz egy menüpontot: ");
//        int choose;
        try{
            int choose= sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    System.out.println(choose);
                    break;
                case 2, 3, 4, 5, 6:
                    System.out.println("under construction");
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
            }
        }catch (InputMismatchException ime){
            System.out.println("Ez nem egy szám");
            printMenu();
        }

    }

    public static void main(String[] args) {
        VaccMain vm= new VaccMain();
        vm.printMenu();
    }
}
