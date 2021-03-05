package vaccination;

public class Citizen {
    private String name;
    private String zip;
    private int age;
    private String email;
    private String taj;

    public void setName(String name) {
        this.name = name;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", taj='" + taj + '\'' +
                '}';
    }
}
