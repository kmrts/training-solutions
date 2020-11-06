package finalmodifier;

public class CylinderCalculator {
    public double calculateVolume(double r, double h){
        //henger térfogata
        return CircleCalculator.PI*r*r*h;

    }
    public double calculateSurfaceArea(double r, double h){
        //henger felszíne
        return 2*CircleCalculator.PI*r*(r+h);

    }
}
