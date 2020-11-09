package operators;

public class Operators {

    public boolean isEven(int n) {
        return n%2==0;
    }

    public int multiplyByPowerOfTwo(int toMult, int times){

        return toMult <<= times;
    }
}
