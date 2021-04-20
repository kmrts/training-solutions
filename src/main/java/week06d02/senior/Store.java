package week06d02.senior;

import java.util.*;

public class Store {
    /*
     Hozz létre egy Product osztályt melynek adattagjai a név, kategória és ár.
    A kategória legyen enum FROZEN, DAIRY, BAKEDGOODS, OTHER felsorolókkal.
    Készíts egy Store osztályt benne egy Product listával, amit konstruktorban kap meg.
    Legyen egy getProductsByCategory() aminek az lényége, hogy visszaadja valamilyen adatszerkezetben,
    hogy melyik kategóriából hány darab van a listában. A "valamilyen adatszerkezet" a kreativításodra van bízva,
    az a lényeg, hogy valahogy egyben kapjam meg, hogy melyik kategóriából hány darab van.
     */

    private List<Product> productList= new ArrayList<>();

    public Store(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }

    public Map<Category, Integer> getProductsByCategory(){
        Map<Category, Integer> prodByCat= new HashMap<>();

        for(Product pr: productList){
            Category actual= pr.getCategory();
            if(!prodByCat.containsKey(actual)){
                prodByCat.put(actual, 0);
            }
            prodByCat.put(actual, prodByCat.get(actual)+1);
        }
        return prodByCat;
    }


}
