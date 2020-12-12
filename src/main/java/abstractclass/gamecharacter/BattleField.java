package abstractclass.gamecharacter;

public class BattleField {
    //Hozz létre egy BattleField osztályt, ami használja a karaktereket.
    //
    //    szükséges attribútumok
    //        round, hány kör van még (int típusú).
    //    generálj egy gettert a round attribútumra.
    //    hozz létre egy private boolean oneHit(Character attacker, Character defender) metódust,
    //    amely igazzal tér vissza, ha mindkét karakter él.
    //    Törzsében meghívja a támadó (attacker) primaryAttack() majd secondaryAttack() metódusait,
    //    melyeknek paramétere a védekező defender, ha még mindkettő él.

    private int round;

    public int getRound() {
        return round;
    }
    private boolean oneHit(Character attacker, Character defender){
        if(attacker.isAlive() && defender.isAlive()){
            attacker.primaryAttack(defender);
        }
        if(attacker.isAlive() && defender.isAlive()){
            attacker.secondaryAttack(defender);
        }
        return attacker.isAlive() && defender.isAlive();
    }
    //    hozz létre egy public Character fight(Character one, Character other) metódust,
    //    amely visszatér az élve maradt karakterrel. Törzsében
    //        mindaddig hívja a privát oneHit metódust felváltva a támadó és védekező szerepeket,
    //        amíg valamelyik meg nem hal. Minden körben először a one támadja az other-t, majd az other a one-t.
    //        közben növeli a round attribútum értékét.
    //        végül visszatért az élő karakter referenciával.
    public Character fight(Character one, Character other){
        int counter= 1;
        while(one.isAlive() && other.isAlive()){
            if(counter%2 == 1){
                oneHit(one, other);
            }else{
                oneHit(other, one);
            }
            counter++;
            round++;
        }
        return one.isAlive() ? one : other;

    }

}
