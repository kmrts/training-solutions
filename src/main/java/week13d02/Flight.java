package week13d02;

public class Flight {
    private String number;
    private FlightType type;
    private String city;
    private String time;

    public Flight(String number, FlightType type, String city, String time) {
        this.number = number;
        this.type = type;
        this.city = city;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public FlightType getType() {
        return type;
    }

    public String getCity() {
        return city;
    }

    public String getTime() {
        return time;
    }
}
