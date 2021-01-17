package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {
    /*
    A StateRegister osztály felelős a file beolvasásáért és a State objektumok létrehozásáért, valamint a keresésért.
    Legyen benne egy lista states , State generikussal, amibe a readStatesfromFile(stringFileName) eltárolja a beolvasott adatokat.
    A findCapitalByStateName(String stateName) megkeresi a paraméterül kapott állam fővárosát.
    Ha nincs ilyen állam akkor IllegalArgument exception-t dob!
     */
    private List<State> states= new ArrayList<>();

    public List<State> getStates() {
//        return states;
        return new ArrayList<>(states); //
    }

    public void readStatesFromFile(String stringFileName){
        Path file= Path.of("src/main/resources/" + stringFileName);
        try (BufferedReader rea = Files.newBufferedReader(file)) {
            String line;
            while( (line= rea.readLine()) != null){
                int index= line.indexOf('-');
                State next= new State(line.substring(0, index), line.substring(index+1));
                states.add(next);
            }
        }catch(IOException ioe){
                throw new IllegalStateException("Can't read file!", ioe);
            }
    }
    public String findCapitalByStateName(String stateName){
        for(State sta: states){
            if(sta.getStateName().equals(stateName)){  ///equals !
                return sta.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }
}
