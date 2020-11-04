package introdate;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("név: ");
        String name= s.nextLine();
        System.out.println("szül év: ");
        int year= s.nextInt();
        System.out.println("szül hó: ");
        int month= s.nextInt();
        System.out.println("szül nap: ");
        int day= s.nextInt();

        Employee emp= new Employee(name, year, month, day);
        //emp.setName(name);

        System.out.println("Név: "+ emp.getName());
        System.out.println("Szül. dát:"  + emp.getDateOfBirth());
        System.out.println("Alkalm. kezd.: "+ emp.getBeginEmployment());
    }
}
