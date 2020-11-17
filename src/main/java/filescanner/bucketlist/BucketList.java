package filescanner.bucketlist;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class BucketList {

    public static void main(String[] args) {

        try(Scanner sc= new Scanner(Path.of("bucketlist.txt"))){  //proj. főkvt-ban kell lennie
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());

            }
        }
        catch (IOException ioe){
            System.out.println("cannot read file");
//            throw new IllegalStateException("cannot read...");
        }
    }
}
