package introconstructors;

public class RestaurantMain {
    public static void main(String[] args) {

        Restaurant resti= new Restaurant("Fehér bika", 12);
        System.out.println(resti.getName()+ " étterem");
        System.out.println("kapacitás: "+resti.getCapacity()+ " fő");

        System.out.println("Ételek: "+resti.getMenu());

    }
}
