package week04;

public class Incrementer {

    public int inc(int i){
        return i +1;
    }

    public static void main(String[] args) {
        Incrementer in = new Incrementer();
        int i= 5;
        System.out.println(in.inc(i));

        boolean b = Boolean.parseBoolean("ajaj");
    }
}
