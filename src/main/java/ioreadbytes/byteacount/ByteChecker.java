package ioreadbytes.byteacount;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ByteChecker {
    /*
    Adott a data.dat állomány melyben rengeteg karakter található.
    A feladatod, hogy számold meg benne az "a" betűket, a videóban látott eszközök segítségével.
     */

    public int readBytesAndFindAs(String fileName){  //116 vs 129 db

        Path file= Path.of("src/main/resources/" + fileName);
        int count= 0;
        try(InputStream ist= new BufferedInputStream(Files.newInputStream(file)) ){
//            byte[] bytes= ist.readAllBytes();
            byte[] bytes= new byte[1000];
            int size;
            while( ( size= ist.read(bytes) ) >0 ){
                System.out.println(size);

                for(byte b: bytes){
                    if(b== 97){
                        count++;
                    }
                }
            }
//            for(int i=0; i< bytes.length; i++){
//                if(bytes[i]== 97){
//                    count++;
//                }
//            }

        } catch (IOException e) {
            throw new IllegalStateException("can not read", e);
        }
        return count;
    }
}
