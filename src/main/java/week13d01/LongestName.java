package week13d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LongestName {
    /*
    A GitHubon a `examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv` fájl tartalmazza a magyar városok listáját.
Add vissza a leghosszabb nevű várost!
     */
    public List<String> readAndLongest(Path source){
        try (BufferedReader br = Files.newBufferedReader(source)) {
            String line;
            int max= Integer.MIN_VALUE;
            List<String> result= new ArrayList<>();
            while ( (line= br.readLine() )!= null){
                String[] spl= line.split(";");
                String name= spl[1].strip();
//                if( spl.length>2 && !spl[2].strip().equals("")){ //ha településrésszel együtt nézzük
//                    name= name+ "-"+spl[2].strip();
//                }
                if(name.length()== max){
                    result.add(name);
                    System.out.println(name);
                }
                if(name.length()> max){
                    System.out.println(name);
                    max= name.length();
                    result.clear();
                    result.add(name);
                }
            }
            return result;
        }catch (IOException e){
            throw new IllegalStateException("cannot read file", e);
        }
    }

    public static void main(String[] args) {
        List<String> st= new LongestName().readAndLongest(Path.of("iranyitoszamok-varosok-2021.csv"));
        System.out.printf("the winner(s): %s", st.toString());
    }
}
