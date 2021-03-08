package vaccination;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class VaccMain {

    public void printMenu() {
        System.out.println("1. Regisztráció\n" +
                "2. Tömeges regisztráció\n" +
                "3. Generálás\n" +
                "4. Oltás\n" +
                "5. Oltás meghiúsulás\n" +
                "6. Riport\n");
    }

    public void chooseFromMenu(DataSource dataSource) {
        System.out.println("Válassz menüpontot: ");
        Scanner sc = new Scanner(System.in);
        try {
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.println("Regisztráció\n");
                    registrate(sc, dataSource);
                    break;
                case 2:
                    System.out.println("Tömeges regisztráció fájlból\n");
                    registrateGroup(sc, dataSource);
                    break;
                case 3:
                    System.out.println("Generálás\n");
                    generateFromZip(sc, dataSource);
                    break;
                case 4:
                    System.out.println("Oltás\n");
                    injVaccine(sc, dataSource);
                    break;
                case 5, 6:
                    System.out.println("under const.");
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
            }

        } catch (InputMismatchException ime) {
            System.out.println("Ez nem egy szám!");
            chooseFromMenu(dataSource);
        }

    }

    private void injVaccine(Scanner sc, DataSource dataSource) {
        /*
        be kell kérni a TAJ számot. Le kell kérdezni, hogy volt-e már oldása.
        Ha nem volt, akkor be kell kérni a dátumot és a típust.
        Ha már volt egy, akkor ki kell írni, hogy mikor és milyen vakcinával.
        Majd be kell írni a dátumot. Ha már kettő volt neki, akkor hibaüzenetet kell kiírni.

        A következő lépésben megtörténik az első oltás.
        Az oltás elvégzéséhez meg kell adni a TAJ számot, a dátumot és az oltóanyag típusát.
Ha a TAJ szám érvénytelen, vagy nincs rá regisztráció, hibaüzenetet kell kiírni.

Azonban az oltás meg is hiúsulhat. Pl. az állampolgár visszautasítja, olyan betegsége van, várandós, stb.
Ezt is rögzíteni kell a rendszerben a TAJ szám, dátum és indoklás megadásával.
         */
        System.out.println("Kérem a taj-számot: ");
        String taj= sc.nextLine();
        //érvényesség
        Vaccine lastVac= new VaccDao(dataSource).writeDataFromCitizen(taj);
        if(lastVac!= null){
            System.out.printf("%d oltást kapott, beoltva legutóbb %s -n", lastVac.getNumber(), lastVac.getLast());
        }
    }

    private void generateFromZip(Scanner sc, DataSource dataSource) {
        /*
        kérje be az irányítószámot, majd a fájlt, amilyen néven el kell menteni
         */
        System.out.println("Kérem az irányítószámot: ");
        String zip= sc.nextLine();
        System.out.println("Kérem a mentendő fájl nevét: ");
        String fileName= sc.nextLine();
        new VaccDao(dataSource).selectCitizensWithZip(zip, fileName);
    }

    private void registrateGroup(Scanner sc, DataSource dataSource) {
        /*
        Tömeges regisztráció: kérje be a fájl elérési útvonalát, ha nincs ott, vagy hibás a fájl, akkor írjon ki hibaüzenetet,
        amúgy töltse be a citizens táblába
         */
        System.out.println("Adja meg a fájl elérési útját: ");
        String path= sc.nextLine();
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line= reader.readLine();
            while ((line = reader.readLine())  != null) {

                String parts[]= line.split(";");
                Citizen cit= new Citizen(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3], parts[4] );
                new VaccDao(dataSource).saveCitizen(cit);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        // NoSuchFile... | több catch, hibaüz.

    }

    private void registrate(Scanner sc, DataSource dataSource) {
        /*

    Ellenőrizzük, a név nem lehet üres
    Ha beírja az irányítószámát, akkor írjuk ki a hozzá tartozó települést
    Ha az irányítószám üres, hibaüzenetet kell kiírni
    Az életkor > 10 és < 150.
    Az e-mail cím legyen formaliag helyes, elegendő, ha legalább 3 karakter, és van benne egy @ karakter
    Az e-mail címét kétszer kell megadni, és másodjára is ugyanazt a címet kell megadni
    A TAJ számot CDV ellenőrzésnek kell alávetni

         */
        Citizen citizen = new Citizen();
//        System.out.println("Kérem a nevet: ");
//        while(!isValidName(sc)){
//            citizen.setName();
//        }
//        String name= sc.nextLine();
//        if(name.isEmpty()){
//
//        }

        System.out.println("Kérem a nevet: ");
        citizen.setName(regName(sc));
        System.out.println("Kérem az irányítószámot: ");
        citizen.setZip(regZipcode(sc));
        System.out.println("Kérem az életkort: ");
        citizen.setAge(regAge(sc));
        System.out.println("Kérem az email-címet: ");
        citizen.setEmail(regEmail(sc));
        System.out.println("Kérem a taj-számot: ");
        citizen.setTaj(regTaj(sc));

        System.out.println(citizen);
        new VaccDao(dataSource).saveCitizen(citizen);

    }


    private String regName(Scanner sc) {

        String name = sc.nextLine();
        while (name.isEmpty()) {
            System.out.println("A név üres, kérem újra: ");
            name = sc.nextLine();
        }

        return name;
    }

    private String regZipcode(Scanner sc) {

        String zip = sc.nextLine();
//        if(zip.isEmpty()){
//            System.out.println("Üres, kérem újra: ");
//            regZipcode(sc);
//        }
        List<String> cities= writeCity(zip);
        while (zip.isEmpty()|| cities.isEmpty()) {
            System.out.println("Üres, vagy nincs ilyen irsz., kérem újra: ");
            zip = sc.nextLine();
            cities= writeCity(zip);
        }
//        String city= writeCity(zip);

        System.out.printf("Az irányítószámhoz tartozó település(ek): %s\n", cities);
        return zip;
    }

    private List<String> writeCity(String zip) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccination?useUnicode=true");
            dataSource.setUser("vaccination");
            dataSource.setPassword("vaccination");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        return new VaccDao(dataSource).writeCityFromZip(zip);
    }

    private int regAge(Scanner sc) {
//        try {
        boolean isNumber = false;
        int age= 0;
        while (!isNumber) {
            if (sc.hasNextInt()) {
                isNumber = true;
                age = sc.nextInt();
                sc.nextLine();
                while (age < 10 || age > 150) {
                    System.out.println("Min 10, max 150, kérném újra: ");
                    age = sc.nextInt();
                    sc.nextLine();
                }
            }else{
                System.out.println("nem szám, kérem újra: ");
                sc.nextLine();  ///
            }
        }
        return age;
//        } catch (InputMismatchException ime) {
//            System.out.println("Ez nem szám!");
//            regAge(sc);
//        }
//        return 0;
    }

    private String regEmail(Scanner sc) {
        String email1 = sc.nextLine();
        while (!isValidEmail(email1)) {
            System.out.println("Nem valid, kérem újra: ");
            email1 = sc.nextLine();
        }
        System.out.println("Kérem az email-címet mégegyszer: ");
        String email2 = sc.nextLine();
        while (!email2.equals(email1)) {
            System.out.println("Nincs egyezés, kérem újra: ");
            email2 = sc.nextLine();
        }
        return email1;
    }

    private boolean isValidEmail(String email) {
        return email.contains("@") && email.length() >= 3;
    }

    private String regTaj(Scanner sc) { //check
        String taj = sc.nextLine();
        while (!isCdvValid(taj)) {
            System.out.println("Nem valid, kérem újra: ");
            taj = sc.nextLine();
        }
        return taj;
    }

    private boolean isCdvValid(String s) {
        /*
        A TAJ szám első nyolc számjegyéből a páratlan helyen állókat hárommal,
        a páros helyen állókat héttel szorozzuk, és a szorzatokat összeadjuk.
        Az összeget tízzel elosztva a maradékot tekintjük a kilencedik, azaz CDV kódnak.
         */

        //szám-e
        if (s.length() != 9) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 8; i++) {

            try {
                int actual = Integer.parseInt(String.valueOf(s.charAt(i))); //(s.substring(i, i+1));
                if (i % 2 != 1) {
                    sum += actual * 3;
                } else {
                    sum += actual * 7;
                }

            } catch (IllegalArgumentException e) {
                return false;
            }

        }
        return (sum % 10 == Integer.parseInt(String.valueOf(s.charAt(8))));

    }

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/vaccination?useUnicode=true");
            dataSource.setUser("vaccination");
            dataSource.setPassword("vaccination");
        }
        catch (SQLException se) {
            throw new IllegalStateException("Can not create data source", se);
        }
        VaccDao vd= new VaccDao(dataSource);

//        Flyway flyway = Flyway.configure().locations("/db/migration/vaccination").dataSource(dataSource).load();
//
////        flyway.clean();
//
//        flyway.migrate();


        VaccMain vm = new VaccMain();
        vm.printMenu();
        vm.chooseFromMenu(dataSource);
//        System.out.println(vm.isCdvValid("111111110"));
//        System.out.println(vm.isCdvValid("111111117"));


    }
}
