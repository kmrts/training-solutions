package inheritancemethods.products;

import java.math.BigDecimal;

public class PacketProduct extends Product{
    //PacketProduct osztály int packingUnit és BigDecimal weightOfBox attribútumokkal.
    // Ezek megadják, hogy a termékből hány darab helyezhető egy dobozba, és annak súlya alapján
    // a csomagolt termék súlya számítható.
    //
    //publikus metódusok:
    //
    // public PackedProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox)
    // public BigDecimal totalWeight(int pieces)
    //
    //Írd felül az örökölt totalWeight() metódust úgy, hogy egy szállítmány (azaz a termékek és a szükséges számú dobozok)
    // összes súlyát adja vissza, szintén numberOfDecimals tizedesre kerekítve.
    // A darabszámtól függően lehet, hogy lesz egy nem tele doboz is!
    // A felüldefiniálás során felhasználhatók örökölt metódusok is!
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PacketProduct(String name, BigDecimal unitWeight, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeight, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        return super.totalWeight(pieces).add(weightOfBox.multiply(BigDecimal.valueOf(pieces/ packingUnit +1)));

    }

}
