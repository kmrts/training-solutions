package attributes.bill;

import java.util.*;

public class BillMain {
    public static void main(String[] args) {
        Item it1= new Item("dinnye", 2, 550);
        Item it2= new Item("alma", 10, 54);

 //       Bill bill= new Bill(Arrays.asList(it1, it2));
//      Arrays.asList miatt nem bővíthető
        List<Item> itemList= new ArrayList<>();
        itemList.add(it1);
        itemList.add(it2);
        Bill bill= new Bill(itemList);
        System.out.println(bill.calculateTotalPrice());

        bill.addItem(new Item("szilva", 2, 600));


        System.out.println(bill.calculateTotalPrice());

    }
}
