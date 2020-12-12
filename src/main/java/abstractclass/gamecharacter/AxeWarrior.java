package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character{
    //Hozz létre egy AxeWarrior osztályt, amely kiterjeszti a Character osztályt a következőképpen:
    //
    //    hozz létre egy konstruktort, amely megkapja a harcos pozícióját és erre állítja be a position örökölt attribútumot.
    //    hozz létre egy privát getActualSecondaryDamage metódust, ami visszaad egy pozitív véletlen egész értéket
    //    amely az elsődleges támadás maximum kétszerese.
    //    implementáld az örökölt secondaryAttack metódust úgy,
    //        hogy ha az ellenség közelebb van mint két egység (használd a Point distance metódust),
    //        akkor meghívja az örökölt hit() metódust, átadva a kapott enemy paramétert
    //        és a getActualSecondaryDamage() metódus visszatérési értékét.

//    public AxeWarrior(Point position) {
//        super(position);
//    }

    public AxeWarrior(Point position, Random random) {  //
       super(position, random);
    }

    private int getActualSecondaryDamage(){
        return getRandom().nextInt(19) +1; //1 - 10 ,* 2, 1 - 20
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if(getPosition().distance(enemy.getPosition()) < 2){
            hit(enemy, getActualSecondaryDamage());
        }
    }
}
