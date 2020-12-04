package week06d05;

public class Biscuit {
    //amelynek van 2 attribútuma: BiscuitType type és int gramAmount. A BiscuitType legyen felsorolásos típus
    // a 3 kedvenc kekszfajtáddal. A Biscuit nevű osztálynak legyen egy static metódusa of néven, mely paraméterként
    // egy BiscuitType-ot, és egy int gramAmount-ot vár és visszaad egy új Biscuit objektumot
    // amelyet a megadott paraméterek alapján hoz létre.
    // Bónusz feladat: konzolra írás esetén a Biscuit jelenítse meg
    // a type és a gramAmount mezőket!
    private BiscuitType type;
    private int gramAmount;

    public Biscuit(BiscuitType type, int gramAmount) {
        this.type = type;
        this.gramAmount = gramAmount;
    }

    public static Biscuit of(BiscuitType bt, int gramAmount){
        return new Biscuit(bt, gramAmount);
    }

    public BiscuitType getType() {
        return type;
    }

    public int getGramAmount() {
        return gramAmount;
    }

    @Override
    public String toString() {
        return "type= " + type + ", gramAmount= " + gramAmount;
    }
}
