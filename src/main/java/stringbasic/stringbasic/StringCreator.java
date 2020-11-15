package stringbasic.stringbasic;

public class StringCreator {
    public String createStringForHeap(){
        String s= new String("azonos");
        return s;
    }
    public String createStringForPool(){
        String s= "azonos";
        return s;
    }

}
