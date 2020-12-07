package introinheritance.employee;

public class BigBoss extends Boss{

    //public int getNumberOfEmployees()
    //public double getBonus()
    //public double getSalary()
    private double bonus;


    public BigBoss(String name, String address, double salary, int numberOfEmployees, double bonus) {
        super(name, address, salary, numberOfEmployees);
        this.bonus = bonus;
//        salary+=bonus;
    }

    public double getBonus() {
        return bonus;
    }
    public double getSalary(){ ///
        return super.getSalary()+ bonus;
    }
//    public int getNumberOfEmployees(){
//        return getNumberOfEmployees();
//    }
}
