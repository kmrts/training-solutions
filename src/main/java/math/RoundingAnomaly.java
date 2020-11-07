package math;

import java.util.Random;

public class RoundingAnomaly {

    Random rnd = new Random();
//    private double[] randoms= new double[size];

    public double[] randomNumbers(int size, double max, int scale){
       double[] randoms= new double[size];
        for (int i=0; i<size; i++) {
            randoms[i]=(Math.round(rnd.nextDouble() *max* Math.pow(10, scale) )) /Math.pow(10, scale);
        }
        return randoms;
    }
    public double roundAfterSum(double[] numbers){
        double sum= 0;
        for (double num: numbers) {
            sum+= num;
        }
        return Math.round(sum);
    }
    public double sumAfterRound(double[] numbers){
        double sum= 0;
        for (double num: numbers) {
            sum+= Math.round(num);
        }
        return sum;

    }
    double difference(int size, double max, int scale){
        double[] nums= randomNumbers(size, max, scale);
        double afterSum= roundAfterSum(nums);
      //  System.out.println(afterSum);
        double afterRound= sumAfterRound(nums);
//        System.out.println(afterRound);
//        System.out.println(Math.abs(afterSum- afterRound));
        return Math.abs(afterSum- afterRound);

    }
    public static void main(String[] args) {

        RoundingAnomaly ra= new RoundingAnomaly();

//        for(double num: ra.randomNumbers(20, 1000000, 5)){
//            System.out.println(num);
//        }
//        ra.difference(20, 1_000_000, 5);

        int count = 100;
        double sum = 0;
        for (int i = 0; i < count; i++) {
            double diff = ra.difference(1000, 1_000_000, 5);
            sum += diff;
            System.out.println("Különbség: " + diff);
        }
        System.out.println("A különbségek átlaga:"+ sum / count);



    }
}
