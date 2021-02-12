package week15d05.senior;

public class CasePerCapita{
    private String country;
    private double perCapita;

    public CasePerCapita(String country, double perCapita) {
        this.country = country;
        this.perCapita = perCapita;
    }

    public String getCountry() {
        return country;
    }

    public double getPerCapita() {
        return perCapita;
    }

    @Override
    public String toString() {
        return "CasePerCapita{" +
                "country='" + country + '\'' +
                ", perCapita=" + perCapita +
                '}';
    }


}
