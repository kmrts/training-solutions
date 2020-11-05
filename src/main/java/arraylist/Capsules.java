package arraylist;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Capsules {

    List<String> cList = new ArrayList<>();

    public void addLast(String add){
        cList.add(add);
    }
    public void addFirst(String add){
        cList.add(0,add);
    }
    public void removeFirst(){
        cList.remove(0);
    }
    public void removeLast(){
        cList.remove(cList.size()-1);
    }

    public List<String> getcList() {
        return cList;
    }

    public static void main(String[] args) {
        Capsules caps= new Capsules();
        caps.addLast("white");
        caps.addLast("red");
        caps.addLast("blue");
        // System.out.println(caps.cList);  //ink. getter
        System.out.println(caps.getcList());
        caps.removeFirst();
        System.out.println(caps.getcList());
        caps.removeLast();
        System.out.println(caps.getcList());
        caps.addFirst("magenta");
        System.out.println(caps.getcList());
    }
}
