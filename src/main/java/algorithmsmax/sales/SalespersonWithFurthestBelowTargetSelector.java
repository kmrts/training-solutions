package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    //    kiválasztja azt az értékesítőt, aki a legnagyobb összeggel alulmúlta a célt

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> salespersonList){

        Salesperson spFurtBelow= null;
        int min = Integer.MAX_VALUE;

        for (Salesperson spItem: salespersonList){

            if (spItem.getDifferenceFromTarget() < min){
                min = spItem.getDifferenceFromTarget();
                spFurtBelow= spItem;
            }
        }
        return spFurtBelow;

//        Salesperson spFurtBelow= null;
//        int max = Integer.MIN_VALUE;
//
//        for (Salesperson spItem: salespersonList){
//            int diff= spItem.getTarget()-spItem.getAmount();
//            if (diff>max){
//                max= diff;
//                spFurtBelow= spItem;
//            }
//        }
//        return spFurtBelow;

    }
}
