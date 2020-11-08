package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1;
        Person person2;

        Person person = new Person("Jack", 30 );
        person1= person;
        person2= person1;

        person2.setName("John");
        System.out.println(person1);
        System.out.println(person2);

        int int1 =24;
        int int2= int1;
        int2++;
        System.out.println(int1);
        System.out.println(int2);

        Person personOther = new Person("Jill", 33);
        person1= personOther;
        System.out.println(person1);
        System.out.println(person2);


    }
}
