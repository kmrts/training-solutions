package arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMain {

    public String numberOfDaysAsString(){
        int[] numberOfDays= {31,28,31,30,31,30,31,31,30,31,30,31};
        return Arrays.toString(numberOfDays) ;
    }
    public List<String> daysOfWeek(){ //
        return Arrays.asList("hétfő", "kedd", "szerda", "csütörtök", "péntek", "szombat", "vasárnap");
    }
    public String multiplicationTableAsString(int size){
        List<Integer> table= new ArrayList<>();
        for (int i=1; i<=size; i++){
            for (int j=1; j<=size; j++){
                table.add(i*j);
            }
        }
        return table.toString();
    }
    public boolean sameTempValues(double[] day, double[] anotherDay){
        return Arrays.equals(day, anotherDay);
    }
    public boolean wonLottery(int[] bet, int[] result){
        return Arrays.equals(bet, result);
    }

    public static void main(String[] args) {
        ArraysMain a= new ArraysMain();
        System.out.println(a.numberOfDaysAsString());

        System.out.println(a.daysOfWeek());
        System.out.println(a.multiplicationTableAsString(6));

        double[] day={15, 25, 28, 14};
        double[] anotherDay={15, 24, 28, 14};
        System.out.println(a.sameTempValues(day, anotherDay) ? "azonos" : "különbözik");

        int[] bet= {11,22,53,12,66};
        int[] result= {22,66,53,12,11};
        //int[] ren= Arrays.sort(bet);
        //System.out.println(ren);
        //System.out.println(a.wonLottery(Arrays.sort(bet), Arrays.sort(result)));
        System.out.println(bet);
        System.out.println(result);



    }

}

