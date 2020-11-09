package primitivetypes;

public class PrimitiveTypesMain {

    public static void main(String[] args) {
        PrimitiveTypes pt = new PrimitiveTypes();
        System.out.println( pt.toBinaryString(100));
        System.out.println(Integer.toBinaryString(100));

//        new Integer(1) + new Integer(2); not a statement

        System.out.println(new Integer(1) + new Integer(2));
    }
}
