package stringconcat.employee;

public class Employee {
    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if(name.isEmpty() || job.isEmpty()){
            throw new IllegalArgumentException("Minden adat megadása kötelező");

        }
        if(salary<=0 && salary%1000!=0){
            throw new IllegalArgumentException("A fiz. 1000-rel oszth. poz. szám legyen!");
        }

        this.name = name;
        this.job = job;
        this.salary = salary;
    }


    @Override
    public String toString() {
        return name + " - " + job + " - "+ salary +" Ft";
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getSalary() {
        return salary;
    }
}
