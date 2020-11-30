package week06d01;

import java.util.List;

public class ListSelector {

    //egy kapott listából minden második elemet kiválogat, és egy szövegként összerak, szögletes zárójelek között.
    //A páros megállapítása index szerint működik. Azaz az első, nulla indexű elem páros, a második, azaz egyes indexű elem páratlan, stb.
    //Ha üres a lista, akkor üres stringet adjunk vissza. Ha a paraméterül kapott lista null, akkor dobjunk IllegalArgumentExceptiont a metódusban.

    //bónusz ,-vel elválasztva

    public String listSel(List<String> list){
        if(list==null){
            throw new IllegalArgumentException("A lista null");
        }

        StringBuilder sb= new StringBuilder("[");

        for (int i=0; i<list.size(); i++){  //i+=2, ha size nem 0
            if(i%2==0){
                sb.append(list.get(i));
                sb.append(",");
            }
        }

        if("[".equals(sb.toString())){  //[]
            return "";
        }else{
            sb.deleteCharAt(sb.length()-1);  //
            sb.append("]");
            return sb.toString();
        }
    }
}
