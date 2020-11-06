package debug.employees;

import java.util.ArrayList;

public class CompanyMain {
    public static void main(String[] args) {

        Employee emp1= new Employee("Jack",1970);
        Employee emp2= new Employee("Jill",1985);
        Employee emp3= new Employee("Ben H",1982);

/////
        Company company =new Company(new ArrayList<>());

        company.addEmployee(emp1);
        company.addEmployee(emp2);
        company.addEmployee(emp3);

    }
}
