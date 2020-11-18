package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    //    kiválasztja azt az értékesítőt, aki a célt a legnagyobb összeggel meghaladta

    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> salespersonList){

        Salesperson spFurtAb= null;
        int max = Integer.MIN_VALUE;
        for (Salesperson spItem: salespersonList){
//            int diff= spItem.getAmount() - spItem.getTarget();
            if (spItem.getDifferenceFromTarget()>max){
                max= spItem.getDifferenceFromTarget();
                spFurtAb= spItem;
            }
        }
        return spFurtAb;
    }
}
