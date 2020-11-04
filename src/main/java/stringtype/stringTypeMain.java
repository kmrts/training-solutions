package stringtype;

public class stringTypeMain {
    public static void main(String[] args) {
        String prefix= "Hello ";
        String name= "John Doe";
        String message= prefix+ name;
        message = message+ 444;
        //System.out.println(message);

        boolean b= message=="Hello John Doe";
        boolean c= message == "Hello John Doe444";

        System.out.println(""+ "");

        System.out.println("Abcde".length());
        System.out.println("Abcde".substring(0,1)+ ", "+ "Abcde".substring(2,3));
        System.out.println("Abcde".substring(0, 3));

    }
}
