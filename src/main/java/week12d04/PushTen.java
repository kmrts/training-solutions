package week12d04;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class PushTen {
    /*
    Töltsd le a példa bináris állomány a
    https://github.com/Training360/strukturavalto-java-public/raw/master/examples/week12d04/src/main/resources/secret.dat címről!
Ez bájtokat tartalmaz, egy szöveg van titkosítva benne. Olvasd be bájtonként, és mindegyik bájthoz adjál hozzá tízet!
Ez valójában egy karakterkód, ezt alakítsd át `char` típusú értékké!
Majd egymás után írd ki ezeket a konzolra! Ne használj közöttük sortörést!
     */
    public byte[] readBytes(String file){
        Path path= Path.of(file);
        try (InputStream is = new BufferedInputStream(Files.newInputStream(path))) {
//            byte[] b= new byte[1000];
//            int size;
//            while( ( size= is.read(b) )>0 ){
//                System.out.println(size);
//            }
            byte[] b= is.readAllBytes();
            return b;
        }catch (IOException ioe){
            throw new IllegalStateException("cannot read file", ioe);
        }
    }
    public void writeCharsfromByteArray(String file){
        byte[] bytes= readBytes(file);

        for(int i= 0; i< bytes.length; i++){
            bytes[i]+= 10;
        }

        String str= new String(bytes);
        System.out.println(str);

//        System.out.println(Arrays.toString(bytes));
    }

    public static void main(String[] args) {
        PushTen pt= new PushTen();

        pt.writeCharsfromByteArray("secret.dat");  //proj. főmappa

    }
}
