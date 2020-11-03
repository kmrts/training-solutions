package localvariables;

public class DistanceMain {
    public static void main(String[] args) {

        Distance distance= new Distance(15.3, true);

        System.out.println(distance.getDistanceInKm());
        System.out.println(distance.isExact());

        int whole= (int)distance.getDistanceInKm();
        System.out.println(whole);
    }
}
