package abstractclass.gamecharacter;

import java.util.Random;

public abstract class Character {   //
    //Definiálj egy karakterek modellezését megvalósító Character absztrakt osztályt.
    //
    //    szükséges attribútumok
    //        position, hol van a karakter (Point típusú).
    //        hitPoint, mennyi életereje van még a karakternek (int típus), alapértelmezett értéke 100.
    //        random, Random típus, véletlenszámok generálásához.
    //        Hozz létre még egy isAlive metódust, amely igazzal tér vissza, ha még él a karakter, azaz a hitPoint nagyobb, 
    //        mint 0 (egyébként hamis).

    private Point position;
    private int hitPoint =100; //= 100;
    private Random random;

    public Character() {
    }

//    public Character(Point position, int hitPoint, Random random) { //
//        this.position = position;
//        this.hitPoint = hitPoint;
//        this.random= new Random(); //
//            }

//    public Character(Point position) {
//        this.position = position;
//        this.hitPoint = 100;
//        this.random= new Random(); //
//    }
    public Character(Point position, Random random) { //
        this.position = position;
        this.random= random;
        this.hitPoint = 100;
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Random getRandom() {
        return random;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setRandom(Random random) { ///
        this.random = random;
    }
    //    public void setHitPoint(int hitPoint) {
//        this.hitPoint = hitPoint;
//    }

    public boolean isAlive(){
        return getHitPoint()>0;
    }
    protected int getActualPrimaryDamage(){
        return random.nextInt(9) +1; //1 - 10
    }
    //    protected getActualPrimaryDamage metódus, amely visszaad egy egy és tíz közötti véletlen értéket (egész).
    //    private getActualDefence metódus, amely visszaad egy nulla és 5 közötti véletlen értéket (egész).
    //    protected void hit(Character enemy, int damage) metódus,
    //        amely lekérdezi az aktuális védelmet (használva a getActualDefence metódust).
    //        Ha gyengébb a védelem, mint a sebzés (damage paraméter), akkor levonja a sebzés értékét az életerőből,
    //        hívja a decreaseHitPoint private metódust.
    //    public void primaryAttack(Character enemy), amely csak továbbhívja a hit metódust a saját enemy paraméterével,
    //    és a getActualPrimaryDamage metódus visszatérési értékével.
    //    private void decreaseHitPoint(int diff), amely levonja a diff paraméter értékét az életerő (hitPoint attribútum) értékéből.
    //    deklarálj egy abstract public void secondaryAttack(Character enemy) metódust,
    //    melyet a leszármazott konkrét osztályok implementálnak majd.
    private int getActualDefence(){
        return random.nextInt(6); //0 - 5
    }
    protected void hit(Character enemy, int damage){
        if(getActualDefence()< damage){
            enemy.decreaseHitPoint(damage); //// enemy
//            System.out.println(enemy.hitPoint);
        }
    }
    public void primaryAttack(Character enemy){
        hit(enemy, getActualPrimaryDamage());
    }
    private void decreaseHitPoint(int diff){
        hitPoint-= diff;
    }
    public abstract void secondaryAttack(Character enemy);  // abstract public void
}
