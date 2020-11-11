package numbers;

public class Circle {
    private int diameter;
    private double PI= 3.14;

    public Circle(int diameter) {
        this.diameter = diameter;
    }

    public double perimeter(){
        return diameter * PI;
    }

    public double area(){
        return Math.pow(diameter/2, 2) *PI;
    }
}
