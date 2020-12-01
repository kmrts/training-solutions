package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {
//    Készíts egy Store osztályt benne egy Product listával, amit konstruktorban kap meg.
    // Legyen egy getProductByCategoryName(Category), ami visszaadja, hogy a paraméterül kapott kategóriából hány darab van a listában.
    //Bónusz: A kategória legyen enum FROZEN,DAIRY,BAKEDGOODS,OTHER felsorolókkal.
    private List<Product> productList= new ArrayList<>();

    public Store(List<Product> productList) {
        this.productList = productList;
    }
    public int getProductByCategoryName(Category category){
        int sum= 0;
        for(Product p: productList){
            if(p.getCategory()== category){
                sum++;
            }
        }
        return sum;
    }
}
