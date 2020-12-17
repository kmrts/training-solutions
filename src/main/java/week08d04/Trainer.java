package week08d04;

public class Trainer {
    //Legyen egy `Trainer` osztály, melynek van egy `CanMark` attribútuma, mely konstruktorral állítható be! És
    //legyen egy `int giveMark()` metódusa, mely továbbhív, azaz "delegál" a `CanMark` példány felé!
    //Hozz létre a `main()` metódusban egy `Trainer` példányt, aki jó hangulatban van (azaz konstruktorban
    //adj át neki egy `GoodMood` példányt, és egy másikat, aki `BadMood` példányt kap! Majd hívd meg
    //a `giveMark()` metódusát mindkettőnek, és nézd meg, mit ad vissza!
    private CanMark canMark;

    public Trainer(CanMark canMark) {
        this.canMark = canMark;
    }
    public int giveMark(){
        return canMark.giveMark();

    }

    public static void main(String[] args) {
        Trainer trainerA= new Trainer(new GoodMood());
        Trainer trainerB= new Trainer(new BadMood());

        System.out.println(trainerA.giveMark());
        System.out.println(trainerB.giveMark());

    }
}
