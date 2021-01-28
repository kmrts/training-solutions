package week13d04;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TemplateMerger {
    /*
    Írj egy a TemplateMerger osztályba egy public String merge(Path file, List<Employee> employees)
metódust, ami felolvassa a fájlt, melynek tartalma:
Az alkalmazott neve: {nev}, születési éve: {ev}
Nyugodtan beolvashatod egy utasítással!
Majd a visszatérési értékként add vissza soronként az alkalmazottakat, abban a formátumban,
mint ahogy a fájlban van, azaz:
Az alkalmazott neve: John Doe, születési éve: 1980
Az alkalmazott neve: Jack Doe, születési éve: 1990
(Persze ehhez kell egy Employee osztály is a megfelelő attribútumokkal.
     */
    public String merge(Path file, List<Employee> employees){
        try{
            String text = Files.readString(file);
            text= forming(text);
            StringBuilder sb= new StringBuilder();
            for(Employee emp: employees){
                sb.append(String.format(text, emp.getName(), emp.getYear()));
                sb.append("\n");
            }
            return sb.toString();
        }catch(IOException e){
            throw new IllegalStateException("can not read file", e);
        }
    }
    public String forming(String text){
        int count= 0;
        for(char ch: text.toCharArray()){
           if(ch== '{'){
               count++;
           }
        }
        StringBuilder sb= new StringBuilder(text);
        for(int i=0; i<count; i++){
            sb.replace( sb.indexOf("{"), sb.indexOf("}")+1, "%s");
        }

        return sb.toString();
    }
}
