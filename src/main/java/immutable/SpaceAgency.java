package immutable;

import java.util.ArrayList;
import java.util.List;

public class SpaceAgency {

    public List<Satellite> satellites= new ArrayList<>();

    public void registerSatellite(Satellite satellite){
        if(satellite==null){
            throw new NullPointerException("Parameter must not be null!");
        }
        satellites.add(satellite);

    }
    public Satellite findSatelliteByRegisterIdent(String registerIdent){
        if(isEmpty(registerIdent)){
            throw new IllegalArgumentException("empty");
        }else{
            for (Satellite sat: satellites){
                if(sat.getRegisterIdent().equals(registerIdent) ){
                    return sat;
                }
            }
            throw new IllegalArgumentException("Satellite with the given registration cannot be found!"+ registerIdent);
        }

    }

    @Override
    public String toString() {
        return satellites.toString();
//        StringBuilder sb= new StringBuilder("[");
//        for(Satellite s: satellites){
//            sb.append(s.toString()+", ");
//        }
//        sb.append("]");
//        return sb.toString();
    }

    private boolean isEmpty(String str){
        if(str.equals("")){
            return true;
        }else{
            return false;
        }
    }
}
