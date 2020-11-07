package week02;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Languages {
    public static void main(String[] args) {

        List<String> prnyelv= new ArrayList<>();
        prnyelv.add("Java");
        prnyelv.add("Python");
        prnyelv.add("JavaScript");

        for (String item: prnyelv){
            if (item.length()>5){
                System.out.println(item);
            }

        }
    }

}
