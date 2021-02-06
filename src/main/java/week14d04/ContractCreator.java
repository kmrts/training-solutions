package week14d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContractCreator {
    /*
    Legyen egy ContractCreator osztály,
melynek van egy ContractCreator(String client, List<Integer> monthlyPrices) konstruktora,
mely létrehoz egy szerződéssablont, a paraméterként
megadott adatokkal, melyet összesen EGY attribútumban tárolj!
Majd írj egy create(String name) metódust, mely a sablon alapján létrehoz egy
új szerződést, de a nevet kicseréli a paraméterként megadott névre.
Próbáld ki, hogy a visszaadott szerződésben módosítod a 12. havi értéket. Ha létrehozol
egy új szerződést a sablon alapján, akkor a 12 havi érték az eredeti sablon alapján van
kitöltve?
     */
    private Contract contract;

    public ContractCreator(String client, List<Integer> monthlyPrices) {
        this.contract= new Contract(client, monthlyPrices);
    }

    public Contract getContract() {
        return contract;
    }
    //    public Contract getContract() {
//        contract.getMonthlyPrices().set(3, 150);
//        return contract;
//    }

    public Contract create(String name){
        return new Contract(name, contract.getMonthlyPrices());  //Cont és ret
    }

    public static void main(String[] args) {
        ContractCreator cc=new ContractCreator("Joe", new ArrayList<>(List.of(100, 200, 400, 100)));
        cc.create("Josy").getMonthlyPrices().set(3, 150);
        Contract jim= cc.create("Jim");

        jim.getMonthlyPrices().set(3, 150);

        System.out.println(jim.getMonthlyPrices());  //150
        System.out.println(cc.getContract().getMonthlyPrices());  //150
    }
}
