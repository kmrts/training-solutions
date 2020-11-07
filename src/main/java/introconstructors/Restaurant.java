package introconstructors;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private List<String> menu;
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = 4* numberOfTables;
        this.menu = new ArrayList<>();

        fillMenu();
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
    public void fillMenu(){
        menu.add("Túrós palacsinta");
        menu.add("Babfőzelék");
        menu.add("Zöldbabos rizs");
        menu.add("Ratatouille provençale");

    }
}
