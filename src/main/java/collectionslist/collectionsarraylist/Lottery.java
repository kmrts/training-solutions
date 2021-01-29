package collectionslist.collectionsarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {
    /*
    Implementálj egy lottó gépet, ahol megadható a lottó típusa (ötös, hatos, stb.) és az is, hogy hány számból válasszon (golyók száma).
    Írj egy osztályt, amely létrehozza a golyókat (List<Integer> értékek), összekeveri, majd megcsinálja a "húzást",
    azaz kiválaszt a lottó típusának megfelelő számú golyót, majd a kihúzott számokat növekvő sorba rendezi és úgy adja vissza.
A húzást a selectWinningNumbers(int lotteryType, int ballCount) metódus végzi, amely egy (List<Integer>) értéket ad vissza.

Hibakezelés
Ha a selectWinningNumbers(int lotteryType, int ballCount) metódust rossz paraméterekkel hívták meg (több vagy ugyanannyi számot kellene kihúzni,
mint amennyit generál), a metódus dobjon egy IllegalArgumentException kivételt.

Megvalósítás
Maximálisan használjuk ki a megfelelő kollekció nyújtotta lehetőségeket!
A visszaadott számok pozitív egész számok, és nem lehetnek nagyobbak, mint amennyi golyó van. A golyók számozása egytől kezdődik.
Ugyanaz a szám nem szerepelhet kétszer.

publikus metódusok:

public List<Integer> selectWinningNumbers(int lotteryType, int ballCount)
Tippek
Nézz utána, hogyan lehet List típusok esetén az elemeket rendezni (mi ennek a feltétele?), a rendezettséget megszüntetni.
     */
    public List<Integer> selectWinningNumbers(int lotteryType, int ballCount) {
        if (lotteryType >= ballCount) {
            throw new IllegalArgumentException("Balls must be more then the winning numbers!");
        }
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= ballCount; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);

        List<Integer> winnerNums = new ArrayList<>();
        Random random = new Random();

        int rest = lotteryType;
        while (rest != 0) {
            int index = random.nextInt(ballCount); // 0- (ballCount-1)
            if (!winnerNums.contains(numList.get(index))) {
                winnerNums.add(numList.get(index));
                rest--;
            }
        }
        Collections.sort(winnerNums);
        return winnerNums;

    }

    //    public void makeBalls(){
//
//    }
    public static void main(String[] args) {
        Lottery lo= new Lottery();

        System.out.println( lo.selectWinningNumbers(5, 90));
    }

}
