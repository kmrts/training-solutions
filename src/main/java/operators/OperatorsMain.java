package operators;

public class OperatorsMain {
    public static void main(String[] args) {

        Operators op= new Operators();
        System.out.println(op.isEven(366) );

        System.out.println(16>>1); //2-vel osztás
        System.out.println(16<<1); //2-vel szorzás

        System.out.println(13>>1);
        System.out.println(13<<1);

        System.out.println(op.multiplyByPowerOfTwo(10, 3));
        System.out.println(op.multiplyByPowerOfTwo(-20, 4));

        System.out.println(0333); //oktális, 3*64+3*8+3*1=219

    }
}
