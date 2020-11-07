package attributes.bill;

import java.util.List;

public class Bill {
    private List<Item> items;

    public Bill(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }
    public void addItem(Item itemToAdd){
        items.add(itemToAdd);
    }
    public int calculateTotalPrice(){
        int sum=0;
        for (Item i: items) {
            sum+= i.getQuantity() * i.getPrice();
        }
        return sum;
    }
}
