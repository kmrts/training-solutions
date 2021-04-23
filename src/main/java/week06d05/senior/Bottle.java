package week06d05.senior;

public class Bottle {
    /*
    Készíts egy Bottle nevű osztályt, amelynek van 2 attribútuma: BottleType type és int filledUntil.
    A BottleType legyen felsorolásos típus az alábbi értékekkel: GLASS_BOTTLE és PET_BOTTLE!
    A Bottle nevű osztálynak legyen egy static metódusa of néven, mely paraméterként egy BottleType-ot vár
    és visszaad egy új Bottle objektumot amelyet a megadott paraméter alapján hoz létre.
    A Bottle osztálynak legyen egy fill metódusa, mely egy int fillAmount paramétert vár.
    A fill meghívása esetén végezzen ellenőrzést, hogy megtelt-e már a Bottle objektum.
    Az ehhez szükséges int maximumAmount mezőt a BottleType tartalmazza!
    Ha túlcsordulna a Bottle objektum, akkor dobj kivételt!
     */
    private BottleType type;
    private int filledUntil;

//    public Bottle(BottleType type, int filledUntil) {
//        this.type = type;
//        this.filledUntil = filledUntil;
//    }

    public Bottle(BottleType type) {
        this.type = type;
    }

    public BottleType getType() {
        return type;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public static Bottle of(BottleType type) {
        return new Bottle(type);
    }

    public void fill(int fillAmount) {
        int fillableAmount = type.getMaximumAmount() - filledUntil;
        if (fillAmount > fillableAmount) {
            throw new IllegalArgumentException("There is not enough space in the bottle");
        }
        filledUntil += fillAmount;
    }


    public static void main(String[] args) {
        Bottle bo1 = Bottle.of(BottleType.GLASS_BOTTLE);
        System.out.println(bo1.getFilledUntil());

        bo1.fill(450);
        System.out.println(bo1.getFilledUntil());
        bo1.fill(350);
        System.out.println(bo1.getFilledUntil());

        Bottle bo2= Bottle.of(BottleType.PET_BOTTLE);
        System.out.println(bo2.filledUntil);

        bo2.fill(600);
        System.out.println(bo2.filledUntil);
        bo2.fill(100);
        System.out.println(bo2.filledUntil);
        bo2.fill(50);
        System.out.println(bo2.filledUntil);
//        bo2.fill(200);
//        System.out.println(bo2.getFilledUntil());

    }
}
