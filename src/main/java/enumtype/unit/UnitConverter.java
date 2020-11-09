package enumtype.unit;

import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public double convert(double length, LengthUnit source, LengthUnit target) {
        if (source == target) {
            return length;
        }
        if (target == LengthUnit.MILLIMETER) {
            return source.getToMm() * length;
        }
        return source.getToMm() * length * (1 / target.getToMm());
    }

    public List<LengthUnit> siUnits() {
        List<LengthUnit> SiList = new ArrayList<>();
        for (LengthUnit lUnit : LengthUnit.values()) {  //
            if (lUnit.isSiOrNot()) {
                SiList.add(lUnit);
            }
        }
        return SiList;
    }
    public double round4(double toRound){
        return Math.round(toRound*10000)/10000.0;  // /10000 nem jó
    }

}
