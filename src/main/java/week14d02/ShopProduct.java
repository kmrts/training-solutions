package week14d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ShopProduct {
    /*
    Mai Junior/Mid-level feladat:
Adott egy fájl melyben online bevásárlások találhatók.
A fájl a még ki nem szállított rendeléseket tartalmazza. Egy sorban egy egyedi azonosító és utána a termékek neve van felsorololva.
Minden vásárlás legalább 2 termékből áll.
```
A233 bread,tomato,flour,sugar
A312 sugar,beer,apple,pear
B3402 meet,soda,cola,bbq_sauce
B341 pasta,passata,basil,cheese
A10 corn,hot_dog,rolls
CM231 beer,chips
C123 pepper,salt,rosmary,pizza_dough,passata,oregano
W34111 pasta,sugar,rosmary,cheese,meet,carrot,potato,tomato
K8921 wine,soda
```
Olvasd be a fájlt és tárold el az adatokat a memóriában, majd oldd meg a következő feladatokat.
1. Egyedi azonosító alapján legyenek lekérdezhetőek a vásárolt termékek ABC sorrendben.
2. Számoljuk össze, egy termék neve alapján, hogy abból a termékből mennyit adtak el.
3. Adjuk vissza egy vásárlási azonosító alapján, hogy hány termék szerepel a vásárlásban.
4. Készíts statisztikát melyben visszaadod, hogy az egyes termékek hányszor szerepelnek a fájlban.
     */
    private Map< String, List<String> > shopMap= new HashMap<>();

    public void readToMapSortedShoppingFile(Path path){

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            while( (line= br.readLine())!= null){
                String[] two= line.trim().split(" ");
                String[] spl= two[1].split(",");
                List<String> nextList= new ArrayList<>();
                for(int i= 0; i< spl.length; i++){
                    nextList.add(spl[i]);

                }
                Collections.sort(nextList);

                shopMap.put(two[0], nextList);
            }

        }catch(IOException e){
            throw new IllegalArgumentException("can not read file", e);
        }
    }
    public List<String> getShopListFromId(String id){   //1
        if( ! shopMap.containsKey(id)){
            throw new IllegalArgumentException("no such ID");
        }
        return shopMap.get(id);
    }
    public Map<String, Integer> productsToMap(){  //4
        Map<String, Integer> volumes= new HashMap<>();

        for(Map.Entry entries: shopMap.entrySet()){
//            System.out.println(entries);
//            List<String> list= new ArrayList(Arrays.asList(entries.getValue())); //<>  //[[basil, cheese, passata, pasta]]

            List<String> list= (List)entries.getValue();  //Object to List  /////

            for(String prod: list){
                if(volumes.containsKey(prod)){
                    volumes.put(prod, volumes.get(prod)+1);
                }else{
                    volumes.put(prod, 1);
                }
            }
//            System.out.println(volumes);
        }
        return volumes;
    }
    public int countProductSaled(String product){
        Map<String, Integer> prodMap= productsToMap();
        if( ! prodMap.containsKey(product)){
            throw new IllegalArgumentException("no such product");
        }
        return prodMap.get(product);
    }
    public int showNumOfProducts(){
        Map<String, Integer> prodMap= productsToMap();
        return prodMap.size();
    }

    public static void main(String[] args) {
        ShopProduct shp= new ShopProduct();

        shp.readToMapSortedShoppingFile(Path.of("src/main/resources/shoplist.txt")) ;
        System.out.println(shp.shopMap.toString());

        System.out.println(shp.getShopListFromId("A10"));  //1

        System.out.println( shp.productsToMap()); //4

        System.out.println( shp.countProductSaled("rosmary")); //2

        System.out.println( shp.showNumOfProducts()); //3

    }
}
