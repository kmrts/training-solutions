package attributes.person;

public class Person {
    private String name;
    private String identificationCard;
 //
    private Address address;

    public Person(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String personToString(){
        return "Név: "+ name+ ", ID: "+ identificationCard;
    }
    public void correctData(String name, String identificationCard){
        this.name= name;
        this.identificationCard = identificationCard;
    } // v setter-el
    public void moveTo(Address modified){
        address= modified;
    }
    public String getAddress(){
        return name+ " címe: "+address.addressToString();
    }


}
