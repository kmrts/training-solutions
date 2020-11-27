package week05d05;

public class User {
    //van egy firstName (String), egy lastName (String) és egy email (String) mezője.
    // Legyen ellenőrzés az User konstruktorában, mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben!
    // Készíts egy metódust is getFullName névvel, mely visszaadja a firstName és a lastName változókat
    // összefűzve. Legyen közöttük egy whitespace (" ").
    //Bónusz feladat: írjunk teszteket
    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(!email.contains("@") || !email.contains(".")){
            throw new IllegalArgumentException ("It should contain '@' and '.' characters.");
        }else{  //else nélkül is ok.
            this.email = email;
        }
//        try{
//            if(email.contains("@") && email.contains(".")){
//                this.email = email;
//            }
//
//        } catch (IllegalArgumentException iae){
//            System.out.println("It should contain '@' and '.' characters.");
//        }
    }

    public String getEmail() {
        return email;
    }

    public String getFullName(){
        return firstName+ " "+ lastName;
    }
}
