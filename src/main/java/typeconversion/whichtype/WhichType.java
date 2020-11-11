package typeconversion.whichtype;

import java.util.ArrayList;
import java.util.List;

public class WhichType {

    public List<Type> whichType(String s){
        List<Type> wType= new ArrayList<>();
        for(Type item: Type.values()){ ///
            Long value= Long.parseLong(s);

            if(value>= item.getMinVal()&& value<= item.getMaxval()){
                wType.add(item);
            }
        }
        return wType;
    }
}
