package week08d01;

import java.util.ArrayList;
import java.util.List;

public class Sultan {
    //A török szultán elhatározza, hogy a 100 nap múlva lévő születésnapján szabadon enged néhány rabot a börtönéből.
    // A börtönben 100 cella van. Mindegyik cella zárva van. Ha egyet fordítunk a kulcson akkor nyitva lesz,
    // ha még egyet akkor zárva ha hármat akkor ismét nyitva és így tovább.
    // A szultán azt a parancsot adja, hogy az első nap mindegyik cellán fordítsanak egyet.
    // (Ekkor minden cella nyitva lesz). A második napon minden másodikon fordítsanak egyet,
    // így minden második zárva lesz.
    // A harmadik napon minden harmadikon fordítsanak egyet így a 3. cella zárva , de a 6. cella például nyitva lesz.
    // A week08d01.Sultan osztályba írj egy metódust openDoors() néven, aminek visszatérési értékéből kiderül,
    // hogy mely ajtók lesznek nyitva a 100. napon! Az osztály szabadon bővíthető!

    //123456
    //122213 122211 100011 1*3, 3*3
    //244426 000000  2*3
    //111111
    //101010
    //100011 3.
    //011100
    //001001
    //000000 6.

    //ford 3*33, 99n 122211 100011
    //100n 211122 011100
    public List<Integer> openDoors() {
        boolean isOpen;
        List<Integer> openList = new ArrayList<>();
        for (int i = 1; i < 100 + 1; i++) {
            if (i % 6 == 0) {
                isOpen = false;
            } else if (i % 3 == 0 || i % 2 == 0) {
                isOpen = true;
            } else {
                isOpen = false;
            }
            if (isOpen) {
                openList.add(i);
            }
        }
        return openList;
    }

    public List<Integer> openDoorsB(int days){
        int cycles= days /3; //33
        cycles%=2;
        int dayOnes= (days%3>=1) ? cycles+1 : cycles;
        int dayTwos= (days%3==2) ? cycles+1 : cycles;
        int dayThrees= cycles;
        int negations= 0;

        boolean isOpen = false;
        List<Integer> openList = new ArrayList<>();

        for (int i = 1; i <= 100; i++){
            negations= dayOnes%2;
            if(i%2==0){
                negations+= dayTwos%2;
            }
            if(i%3==0){
                negations+= dayThrees%2;
            }
            negations%=2;

            if(negations== 1){
                openList.add(i);
            }
        }
        return openList;
    }


    public List<Integer> openDoorsC(int doors, int days, int circles){

        List<Integer> openList = new ArrayList<>();

        for (int i = 1; i <= doors; i++){
            int negations= 0;

            for(int j= 1; j<= days; j++){
                int dik= j%circles;
                if(dik==0){dik=circles;};
                if(i%dik==0){
                    negations++;
                }
            }
            negations%=2;
            if(negations== 1){
                openList.add(i);
            }
        }
        return openList;
    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan();
        System.out.println(sultan.openDoors().toString());

        System.out.println(sultan.openDoorsB(100) +"\n");
        System.out.println(sultan.openDoorsB(1));
        System.out.println(sultan.openDoorsB(2));
        System.out.println(sultan.openDoorsB(3));
        System.out.println(sultan.openDoorsB(4) +"\n");

        System.out.println(sultan.openDoorsC(100, 100, 3) +"\n");
        System.out.println(sultan.openDoorsC(10, 39, 3));
        System.out.println(sultan.openDoorsC(10, 40, 3));

        System.out.println(sultan.openDoorsC(25, 25, 3) +"\n");

        System.out.println(sultan.openDoorsC(70, 70, 3));
        System.out.println(sultan.openDoorsC(70, 70, 4));

        System.out.println(sultan.openDoorsC(60, 20, 7));
        System.out.println(sultan.openDoorsC(60, 22, 7));
    }
}
