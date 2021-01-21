package meetingrooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Office office;

    public void readOffice(Office office){ //
///
        System.out.print("Hány db tárgyaló van? ");
        Scanner s= new Scanner(System.in);
        int numOfR = s.nextInt();
        s.nextLine();
        for (int i=0; i<numOfR; i++){
            System.out.print(i+1+". tárgyaló neve: ");
            String name= s.nextLine();
            System.out.print(i+1+". tárgyaló hossza: ");
            int length= s.nextInt();
            s.nextLine();
            System.out.print(i+1+". tárgyaló szélessége: ");
            int width= s.nextInt();
            s.nextLine();
            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    public void printMenu(){
        System.out.println();
        System.out.println("1. Tárgyalók sorrendben");
        System.out.println("2. Tárgyalók visszafele sorrendben");
        System.out.println("3. Minden második tárgyaló");
        System.out.println("4. Területek");
        System.out.println("5. Keresés pontos név alapján");
        System.out.println("6. Keresés névtöredék alapján");
        System.out.println("7. Keresés terület alapján");
    }

    public void runMenu(Office office) {//
        System.out.println();
        System.out.print("Válassz a menüből: ");
        Scanner s = new Scanner(System.in);
        int menuPont = s.nextInt();
        System.out.println();

        if (menuPont == 1) {
            office.printNames();
        } else {
            if (menuPont == 2) {
                office.printNamesReverse();
            } else {
                if (menuPont == 3) {
                    office.printEventNames();
                } else {
                    if (menuPont == 4) {
                        office.printAreas();
                    } else {
                        if (menuPont == 5) {/////
                            s.nextLine();
                            System.out.print("Tárgyaló neve: ");
                            String name= s.nextLine();
                            office.printMeetingRoomsWithName(name);
                        } else {
                            if (menuPont == 6) {
                                s.nextLine();
                                System.out.print("Tárgyaló nevének részlete: ");
                                String part= s.nextLine();
                                office.printMeetingRoomsContains(part);
                            } else {
                                if (menuPont == 7) {
                                    //System.out.println();
                                    System.out.print("Mekkora területnél nagyobb? ");
                                    int area=s.nextInt();
                                    office.printAreasLargerThan(area);
                                }
                            }
                        }
                    }
                }
            }
        }
    }




    public static void main(String[] args){
        Controller con= new Controller();
     //   Scanner s= new Scanner(System.in);
        List<MeetingRoom> mrList= new ArrayList<>();
        Office office= new Office(mrList); ///
        con.readOffice(office);
        con.printMenu();
        con.runMenu(office);

//        con.runMenu(office);
//
//        con.runMenu(office);
//
//        con.runMenu(office);
//
//        con.runMenu(office);
//        con.runMenu(office);


    }
}
