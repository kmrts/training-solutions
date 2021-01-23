package ioconvert.shopping;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingListManager {
    /*
    készíts egy ShoppingListManager osztályt!
    A saveShoppingList() metódusa a paraméterül kapott OutputStream-re kiírja a szintén paraméterül kapott List<String> tartalmát
    szövegként, minden elemet külön sorba.
    A loadShoppingList() metódusa a paraméterül kapott Inputstream-ből beolvassa a bevásárlólista tartalmát, amit szöveglistaként ad vissza.
     */
    public void saveShoppingList(OutputStream outputStream, List<String> shopping){

        try (PrintStream ps = new PrintStream(new BufferedOutputStream(outputStream))) {
            //BufferedWriter, OutputStreamWriter
            for(String item: shopping){
                ps.println(item);
            }
        }catch (Exception e){  //IOException not
            throw new IllegalStateException("cannot write", e);
        }

    }
    public List<String> loadShoppingList(InputStream inputStream){
        List<String> shoppingList= new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader( inputStream) ) )  {
            String line;
            while( (line= br.readLine())!= null){
                shoppingList.add(line);
            }

        }catch (IOException e){
            throw new IllegalStateException("", e);
        }
        return shoppingList;
    }
}
