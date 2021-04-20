package week06d04.senior;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    /*
    A ShoppingCart osztályba dolgozz! Legyen egy addItem(String name, int quantity) metódusa,
    mellyel új bevásárlólista tételt lehet felvenni (termék neve és mennyisége).
    Az adatokat egy Item listába tárolja.
    Amennyiben már benne van az adott termék, ne újonnan vegye fel, hanem adja hozzá a mennyiséget a már felvett tételhez!
    Lehessen visszakérdezni név alapján a felvett mennyiséget a getItem(String name): int metódussal.
    Ha nem szerepel benne, 0 értéket adjon vissza!

    15,37
     */
    private List<Item> itemList= new ArrayList<>();

    public List<Item> getItemList() {
        return new ArrayList<>(itemList);
    }

    public void addItem(String name, int quantity){

        for(Item item: itemList){
            if(name.equals(item.getName())){
                int ind= itemList.indexOf(item);

                itemList.set(ind, new Item(item.getName(), item.getQuantity()+ quantity));
                return;
            }
        }

        Item newItem= new Item(name, quantity);
        itemList.add(newItem);

    }
    public int getItem(String name){
        for(Item i: itemList){
            if(name.equals( i.getName() )){
                return i.getQuantity();
            }
        }
        return 0;
    }
}
