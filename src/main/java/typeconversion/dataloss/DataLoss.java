package typeconversion.dataloss;

public class DataLoss {

    public int dataLoss(){
        long conv;
        int counter=0;
        for(long l=10_000_000; l<20_000_001; l++){    //10_000_000 ig nem volt
            conv= (long) (float)l;
            if(l!= conv){
                System.out.println(counter+1 + ". eltérés: ");
                System.out.println("eredeti  konvertált  eredeti bináris  konvertált bin.  különbség");
                System.out.println(l+ " "+ conv+ " "+ Long.toBinaryString(l)+ " "+ Long.toBinaryString(conv)+ " "+(conv - l));
                counter++;
            }
            if(counter==4){
                return -1;
            }
//            System.out.println(l);
        }
        return -2;
    }

    public static void main(String[] args) {
        DataLoss d= new DataLoss();

        d.dataLoss(); // 25 jegynél
    }

}
