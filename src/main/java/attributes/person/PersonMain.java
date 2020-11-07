package attributes.person;

import introdate.Performance;

public class PersonMain {
    public static void main(String[] args) {
        Person per1= new Person("Béla", "C452369");
        System.out.println(per1.personToString());
        System.out.println(per1.getIdentificationCard());

        per1.correctData("Béla", "C452399");
        System.out.println(per1.personToString());

        Address adr= new Address("Hungary", "Aba", "Fő u. 2", "5555");
        System.out.println(adr.addressToString());

        per1.setAddress(adr);
        System.out.println(per1.getAddress());

        Address adr2= new Address("Hungary", "Pécs", "Fő tér 12.", "4444" );
        per1.moveTo(adr2);
        System.out.println(per1.getAddress());
    }
}
