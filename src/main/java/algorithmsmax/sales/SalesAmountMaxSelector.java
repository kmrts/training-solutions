package algorithmsmax.sales;

import java.util.List;

public class SalesAmountMaxSelector {

    //    kiválasztja a legnagyobb árbevételt elért értékesítőt
    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> salespersonList){

        int maxAmount= Integer.MIN_VALUE;
        Salesperson maxPerson = null;
        for (Salesperson spItem: salespersonList){
            if (spItem.getAmount()>maxAmount){
                maxAmount= spItem.getAmount();
                maxPerson= spItem;

            }
        }
        return maxPerson;
    }
}
