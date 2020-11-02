package classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {

        Client client= new Client();
        client.setName("Joe");
        client.setAddress("Budapest, Kő út 22.");
        client.setYear(1979);

        client.migrate("Kecskemét, Kavics u. 33.");

    }
}
