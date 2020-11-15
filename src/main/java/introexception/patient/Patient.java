package introexception.patient;

public class Patient {
    private String name;
    private String socialSecurityNumber;
    private int yearOfBirth;

    public Patient(String name, String ssn, int year) {
        if (name== null || name.isEmpty()) {///
            throw new IllegalArgumentException("név nem lehet üres");
        }
        if (year<1900){
            throw new IllegalArgumentException("Az évszám min. 1900");
        }

        this.name = name;
        this.socialSecurityNumber = ssn;
        this.yearOfBirth = year;
    }

    public String getName() {
        return name;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
}
