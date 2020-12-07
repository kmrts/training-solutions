package introinheritance.employee;

public class Person {
    //Ezek egy munkahelyi hierarchiát reprezentálnak, a fenti sorrendben egymásból öröklődő osztályok.
    // Jelen esetben a Person osztályt nem is példányosítjuk, ez az alatta levő osztályok egyfajta absztrakciójának tekinthető.
    // A különböző alkalmazottak fizetését eltérő módon számítjuk.
    // Míg az Employee alapfizetéssel rendelkezik, a Boss esetében az alapfizetéshez hozzáadódik
    // a vezetői pótlék (beosztottak száma * LEADERSHIP_FACTOR * alapfizetés), míg a BigBoss esetében ehhez
    // hozzáadódik egy vezetői prémium is (bonus).

    private String name;
    private String address;

    public Person(){

    }

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void migrate(String newAddress){
        address= newAddress;
    }
}
