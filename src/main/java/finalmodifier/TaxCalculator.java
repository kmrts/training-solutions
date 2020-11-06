package finalmodifier;

public class TaxCalculator {
    public static final double AFA= 0.27;

    public double tax(double price){
        return price*AFA;
    }

    public double priceWithTax(double price){
        return price*(1+AFA);
    }

    public static void main(String[] args) {
        TaxCalculator taxc = new TaxCalculator();

        System.out.println(100 + " egység áfa tartalma: "+ taxc.tax(100));
        System.out.println(100 + " egység áfával:       "+ taxc.priceWithTax(100));
    }
}
