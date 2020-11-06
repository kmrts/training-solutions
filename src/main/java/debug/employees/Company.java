package debug.employees;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private List<Employee> employees;

    public Company(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee emp){
        employees.add(emp);

    }
    public Employee findEmployeeByName(String name){
        //
        return null;

    }
    public List<String> listEmployeeNames(){
        //
        return null;
    }


}
