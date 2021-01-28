package week13d04;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TemplateMergerTest {

    @Test
    void testMerge(){
        TemplateMerger tm= new TemplateMerger();
        List<Employee> employeeList= Arrays.asList(new Employee("Derek", "1985"),
                new Employee("Duke", "1975"),
                new Employee("Jenny", "1990"));

        System.out.println(tm.merge(Path.of("form.txt"), employeeList) );
    }

}