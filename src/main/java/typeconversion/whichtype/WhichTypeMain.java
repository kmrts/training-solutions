package typeconversion.whichtype;

public class WhichTypeMain {

    public static void main(String[] args) {

        WhichType wt= new WhichType();
        System.out.println(wt.whichType("80000"));
        System.out.println(wt.whichType("30000"));
        System.out.println(wt.whichType(Short.toString(Short.MAX_VALUE)));
    }
}
