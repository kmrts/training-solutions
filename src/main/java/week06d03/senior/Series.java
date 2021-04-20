package week06d03.senior;

import java.util.List;

public class Series {
    /*
    A Series osztályban hozz létre egy calculateSeriesType() metódust, mely egész számok listáját kapja,
    és eldönti, hogy növekvő, csökkenő vagy össze-vissza sorozatról van-e szó!
    Feltétel, hogy a bemeneti lista nem tartalmaz egymás után egyenlő értékeket.
    Ha a lista üres, vagy csak egy elemből áll, dobj kivételt! Mivel térnél vissza?
    (45p)
     */

    public SeriesType calculateSeriesType(List<Integer> numList){
        if(numList.isEmpty() || numList.size()<= 1){
            throw new IllegalArgumentException("The list is empty or has only 1 item");
        }

        SeriesType first= checkNeib(numList.get(1), numList.get(0));

        for(int i=1; i< numList.size(); i++){
            SeriesType actual= checkNeib(numList.get(i), numList.get(i-1));
            if(actual!= first){
                return SeriesType.MIXED;
            }
        }
        return first;
    }

    private SeriesType checkNeib(int second, int first) {
        if(second== first){
            throw new IllegalArgumentException("Neighboring items can not be equal");
        }
        return second> first ? SeriesType.INCREASING : SeriesType.DECREASING;
    }

}
