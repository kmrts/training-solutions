package finalmodifier;

import java.sql.SQLOutput;

public class PiMain {
    public static void main(String[] args) {
        CircleCalculator ci= new CircleCalculator();
        System.out.println(ci.calculatePerimeter(10));
        System.out.println(ci.calculateArea(10));

        CylinderCalculator cy=new CylinderCalculator();
        System.out.println(cy.calculateVolume(10, 20));
        System.out.println(cy.calculateSurfaceArea(10, 20));

        System.out.println("Pi: "+ CircleCalculator.PI);
    }
}
