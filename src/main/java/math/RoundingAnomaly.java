package math;

import java.util.Random;

public class RoundingAnomaly {

    Random rnd = new Random();

    public double[] randomNumbers(int size, double max, int scale){
        double[] randoms= new double[size];
        for (int i=0; i<size; i++) {
            randoms[i]=(Math.round(rnd.nextDouble() *max* Math.pow(10, scale) )) /Math.pow(10, scale);
        }
        return randoms;
    }


    public static void main(String[] args) {

        RoundingAnomaly ra= new RoundingAnomaly();

        //System.out.println(ra.randomNumbers(10, 1000000, 5).toString() );
        //double[] tomb = new ra.randomNumbers(10, 1000000, 5);
        for(double num: ra.randomNumbers(20, 1000000, 5)){
            System.out.println(num);
        }


    }
}
