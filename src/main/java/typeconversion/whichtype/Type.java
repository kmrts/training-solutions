package typeconversion.whichtype;

public enum Type {
    BYTE(-128, 128),
    SHORT(-32768,32767),
    INT(-2_147_483_648, 2_147_483_647);

    //Byte.MIN_VALUE

    private final long minVal; //
    private final long maxval; //

    Type(long minVal, long maxval) {
        this.minVal = minVal;
        this.maxval = maxval;
    }

    public long getMinVal() {
        return minVal;
    }

    public long getMaxval() {
        return maxval;
    }
}
