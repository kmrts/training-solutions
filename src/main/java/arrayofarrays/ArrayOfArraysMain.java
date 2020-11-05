package arrayofarrays;

public class ArrayOfArraysMain {

    public int[][] multiplicationTable(int size){
        int[][] table= new int[size][size];
        for (int s=0; s<size; s++){
           for (int o=0; o<size; o++){
               table[s][o]=(s+1) * (o+1);
           }
        }
        return table; //
    }

    public void printTable(int[][] a){ //
        for (int i[]: a) {
            for (int j: i
                 ) {
                System.out.println(j);
            }
            System.out.println();
        }
    }
    public int[][] triangularMatrix(int size){
        int[][] trian= new int[size][];
        for (int i=0; i<trian.length; i++){
            trian[i]= new int[i+1];
            for (int j=0; j<i+1; j++){
                trian[i][j]= i;
            }
        }
        return trian;
    }

    public int[][] getValues(){
        int[][] months= new int[12][];

        int[] days= {31,28,31,30,31,30,31,31,30,31,30,31};
        for (int i=0; i<12; i++){
            months[i]= new int[days[i]];
        }
        return months;
    }

    public static void main(String[] args) {

        ArrayOfArraysMain aa= new ArrayOfArraysMain();
        aa.printTable(aa.multiplicationTable(5)); //
        //int[][] i={{1,2,3},{2,4,6}};
       // aa.printTable(i);

        aa.printTable(aa.triangularMatrix(4));

        aa.printTable(aa.getValues());

    }


}
