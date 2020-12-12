package abstractclass.gamecharacter;

public class Point {
    //Feladat egy egyszerű játék logikájának megvalósítása.
    // Ez a játék két konkrét játék karaktert támogat: a nyilast, és a baltás harcost.
    // Vannak közös viselkedések, azért bevezetünk egy karakter közös őst.
    // Mivel azonban van olyan viselkedés, amely különbözik (de minden karakternek van) a második szintű támadás,
    // ezért a közös ős absztrakt. A megoldások az abstractclass.gamecharacter csomagban legyenek.
    //
    //Definiálj egy síkpont tárolására képes immutable Point osztályt, x és y long típusú attribútumokkal.
    // Definiálj egy distance metódust, amely megkap egy másik pontot, és visszatér a két pont távolságával (Pitagorasz-tétel).
    private long x;
    private long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public long distance(Point otherPoint){
        return (long)Math.sqrt( Math.pow((double)otherPoint.getX()-x, 2) + Math.pow((double)otherPoint.getY()-y, 2) );
    }
}
