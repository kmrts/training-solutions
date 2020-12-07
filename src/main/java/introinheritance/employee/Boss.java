package introinheritance.employee;

public class Boss extends Employee{

    private static final double LEADERSHIP_FACTOR = 0.1;  //static
    private int numberOfEmployees;

    public Boss() {

    }

    public Boss(String name, String address, double salary, int numberOfEmployees) {
        super(name, address, salary);

        this.numberOfEmployees = numberOfEmployees;

    }

    public double getLEADERSHIP_FACTOR() {
        return LEADERSHIP_FACTOR;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public double getSalary(){  ///ez
        return super.getSalary()+ super.getSalary() *LEADERSHIP_FACTOR *numberOfEmployees;
    }

}
