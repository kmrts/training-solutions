package week08d02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {
    //egy Lottery osztályt, melynek legyen egy getNumbers() metódusa, ami visszaad egy listát amiben 5 véletlen szám van 1-90 között,
    // tehát kvázi készíts egy lottósorsoló programot. A sorrendre nem kell figyelni, a lényeg, hogy a számok különbözők legyenek!


    public List<Integer> getNumbers(){
        Random random= new Random();
        List<Integer> list= new ArrayList<>();
        int count=0;
        while(count<5){
            int num= random.nextInt(90)+1;
            if(!list.contains(num)){
                list.add(num);
                count++;
            }
        }
        return list;

    }

    public static void main(String[] args) {
        Lottery lott = new Lottery();

        System.out.println(lott.getNumbers().toString());
    }
}
