package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {
    public List<DayType> dayTypes(Day firstDay, int numberOfDays){
        List<DayType> typeList = new ArrayList<>();
        Day currType= firstDay;
        for(int i=0; i<numberOfDays; i++){
            typeList.add(currType.getDayType());
            currType= nextDay(currType);
        }
        return typeList;
    }
    private Day nextDay(Day day){  ///
        if (day.ordinal() +1 == Day.values().length) {
            return Day.values()[0];
        } else {
            return Day.values()[day.ordinal() + 1];
        }

    }
}
