package algorithmssum.sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountSumCalculator {


    public int sumSalesAmount(List<Salesperson> sPersons){
        int sum=0;
        for (Salesperson spItem: sPersons){
            sum+= spItem.getAmount();
        }
        return sum;
    }
}
