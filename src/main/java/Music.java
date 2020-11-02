import java.util.Scanner;

public class Music {
    public static void main(String[] args) {

        Song song= new Song();
        Scanner scanner= new Scanner(System.in);

        System.out.println("Kérem a dal előadóját: ");
        song.band= scanner.nextLine();
        System.out.println("Kérem a dal címét: ");
        song.title= scanner.nextLine();
        System.out.println("Kérem a dal hosszát percben: ");
        song.length= scanner.nextLine();

        System.out.println(song.band + " - "+ song.title+ " ("+ song.length+ " perc)");
    }
}
