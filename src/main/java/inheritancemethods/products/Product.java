package inheritancemethods.products;

import java.math.BigDecimal;

public class Product {
    //Az ős Product osztály adott terméket reprezentál, a PackedProduct osztály ennek becsomagolt specializációja.
    // Egymástól metódusokat örökölnek, de ezeket az osztályra jellemző módon felül kell írni (overwriting).
    //
    //Product osztály String name, BigDecimal unitWeight és int numberOfDecimals attribútumokkal.
    // Ha a tizedes értékek száma nics megadva, alapértelmezetten két tizedesjeggyel számolunk (egységként kg értendő).
    //
    //publikus metódusok:
    //
    // public Product(String name, BigDecimal unitWeigth, int numberOfDecimals)
    // public Product(String name, BigDecimal unitWeigth)
    // public BigDecimal totalWeight(int pieces)
    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;

    public Product(String name, BigDecimal unitWeight, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeight) {
        this.name = name;
        this.unitWeight = unitWeight;
        this.numberOfDecimals = 2;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public BigDecimal totalWeight(int pieces){
        return unitWeight.multiply(BigDecimal.valueOf(pieces));
    }
}
