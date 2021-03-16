package zarovizsgelott;

public class OfficeSoftware extends Software{

    public OfficeSoftware(String name, int price) {
        super(name, price);
    }

//    void increasePrice() {
////        super.increasePrice();
//        price *= 1.05;
//    }


    @Override
    public void increasePrice() {
        price *= 1.05;
    }
}
