package intromethods;

public class EmployeeMain {
    public static void main(String[] args) {

        Employee emp = new Employee("Joe", 2010, 200_000 );
        System.out.println(emp.toString());
        //Employee{name='Joe', hiringYear=2010, salary=200000}
        System.out.println(emp);
        //Employee{name='Joe', hiringYear=2010, salary=200000}

        //toString dekl. nélkül, mindkettő:
        //intromethods.Employee@7699a589

        emp.raiseSalary(50_000);
        System.out.println(emp.getSalary());
    }
}
