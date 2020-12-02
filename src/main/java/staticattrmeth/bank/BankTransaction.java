package staticattrmeth.bank;

import java.math.BigDecimal;

public class BankTransaction {
      //A megoldás készüljön fel arra az (egyébként nem túl valószínű) esetre is, ha egyetlen érvényes tranzakció sem volt.
    // Ilyenkor az averageOfTransaction, a getCurrentMinValue és a getCurrentMaxValue metódusok nullát adjanak vissza.
    //
    //Több esetben jól alkalmazható a Java három operandusú művelete!

    private long trxValue;
    private static long currentMinValue;
    private static long currentMaxValue;
    private static BigDecimal sumOfTrxs;//=BigDecimal.valueOf(0);
    private static int numOfT; //=0;

    private static final long MIN= 1;
    private static final long MAX= 10_000_000;


    public BankTransaction(long trxValue) {
        if(trxValue<MIN || trxValue>MAX){
            throw new IllegalArgumentException(String.format("The value should be between %f and %f", MIN, MAX));
        }
        this.trxValue = trxValue;
        numOfT++;
        sumOfTrxs= sumOfTrxs.add(BigDecimal.valueOf(trxValue));  //
        if(trxValue< currentMinValue){
            currentMinValue= trxValue;
        }
        if(trxValue> currentMaxValue){
            currentMaxValue= trxValue;
        }
    }

    public long getTrxValue() {
        return trxValue;
    }

    public static long getCurrentMinValue() {
//        if(numOfT==0){
//            return 0;
//        }
//        return currentMinValue;
        return (numOfT==0 ? 0 : currentMinValue);
    }

    public static long getCurrentMaxValue() {
//        if(numOfT==0){
//            return 0;
//        }
//        return currentMaxValue;
        return (numOfT==0 ? 0 : currentMaxValue);
    }

    public static BigDecimal getSumOfTrxs() {
        return sumOfTrxs;
    }

    public static int getNumOfT() {
        return numOfT;
    }

    public static void initTheDay(){
        currentMinValue= Long.MAX_VALUE;
        currentMaxValue= Long.MIN_VALUE;
        sumOfTrxs=BigDecimal.valueOf(0);
        numOfT= 0;
    }
    public static BigDecimal averageOfTransaction(){
        if(numOfT==0){
            return BigDecimal.valueOf(0); //new BigDecimal(0);
        }
        return sumOfTrxs.divide(BigDecimal.valueOf(numOfT));
    }
}
