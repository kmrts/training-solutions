package abstractclass.gamecharacter;

import java.util.Random;

public class Archer extends Character{
    //Hozz létre egy Archer osztályt, amely kiterjeszti a Character osztályt a következőképpen:
    //
    //    szükséges attribútumok
    //        numberOfArrow, hány nyíl van még (int típusú).
    //    hozz létre egy konstruktort, amely megkapja a nyílas pozícióját és erre állítja be a position örökölt attribútumot.
    //    Állítsa be a numberOfArrow attribútum értékét 100-ra.
    //    generálj gettert a numberOfArrow attribútumra.

    private int numberOfArrow;

    public Archer(Point position) {
//        super(hitPoint);

        setPosition(position);
        this.numberOfArrow = 100;

    }

    public Archer(Point position, Random random) {  ///
        super(position,  random);

//        setPosition(position);
//        setRandom(random);
        this.numberOfArrow = 100;
    }

    public int getNumberOfArrow() {
        return numberOfArrow;
    }
    private int getActualSecondaryDamage(){
        return getRandom().nextInt(5) +1; //1 - 5  //
    }
    //    hozz létre egy privát getActualSecondaryDamage metódust, ami visszaad egy 1 és 5 közötti egész véletlen értéket.
    //    definiálj egy shootingAnArrow privát metódust, amely megkapja az ellenséges karakter referenciáját (enemy).
    //    Csökkenti a nyílak számát numberOfArrow, és meghívja a hit örökölt metódusát a kapott ellenséges karakter referenciával,
    //    és a getActualSecondaryDamage metódus visszatérési értékével.
    //    implementáld az örökölt secondaryAttack metódust úgy, hogy meghívod az előzőleg definiált privát shootingAnArrow metódust,
    //    átadva a kapott enemy paramétert.
    private void shootingAnArrow(Character enemy){
        numberOfArrow--;
        hit(enemy, getActualSecondaryDamage());
    }
//    public void secondaryAttack


    @Override
    public void secondaryAttack(Character enemy) {  //
        shootingAnArrow(enemy);
    }
}
