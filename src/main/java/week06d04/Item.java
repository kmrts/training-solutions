package week06d04;

public class Item {

    public int price;
    public int month;
    public String name;

    public Item(int price, int month, String name) {
        this.price = price;
        this.month = month;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public int getMonth() {
        return month;
    }

    public String getName() {
        return name;
    }
}
