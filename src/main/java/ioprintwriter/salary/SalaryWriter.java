package ioprintwriter.salary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SalaryWriter {
    /*
    Ebben a feladatban emberek fizetését kell meghatároznod titulus alapján.
    A SalaryWriter osztály konstruktorban kap egy név listát.
    A writeNamesAndSalaries(Path file) metódus kiírja a fájlba név: összeg formátumban. A fizetések a következő képpen alakulnak:

    Ha tartalmazza a név a "Dr" előtagot, akkor 500000
    Ha a "Mr" vagy "Mrs" előtagot akkor 200000
    Különben 100000
     */
    private List<String> names;

    public SalaryWriter(List<String> names) {
        this.names = names;
    }

    public void writeNamesAndSalaries(Path file) {
        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(file))) {
            int salary;
            for (String name : names) {
                salary=100_000;
                if (name.startsWith("Mr.") || name.startsWith("Mrs.")) {
                    salary = 200_000;
                }
                if (name.startsWith("Dr.")) {
                    salary = 500_000;
                }
                pw.print(name+": ");
                pw.println(salary);
            }
        } catch (IOException e) {
            throw new IllegalStateException("cannot write file", e);
        }
    }
}
