package statements;

public class Investment {
    private double cost;
    private int fund;
    private int interestRate;
    private boolean active;

    public Investment(int fund, int interestRate) {

        this.fund = fund;
        this.interestRate = interestRate;
        this.active= true;
        this.cost= 0.3;
    }

    public int getFund() {
        return fund;
    }
    public int getInterestRate() {
        return interestRate;
    }

    public double getYield(int days){
        return fund * (double)interestRate/100/360 * days;
    }
    public double close(int days){
        double amount= active ? (fund + getYield(days) - fund* cost/100) : 0.0;
        active= false;
        return amount;
    }
}
