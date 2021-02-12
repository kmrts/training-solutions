package week15d05.senior;

public class CountryCase {
    private String country;
    private int population;
    private int sumCases;
    private int counter;

    public CountryCase(String country, int population, int sumCases, int counter) {
        this.country = country;
        this.population = population;
        this.sumCases = sumCases;
        this.counter = counter;
    }

    public String getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    public int getSumCases() {
        return sumCases;
    }

    public int getCounter() {
        return counter;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setSumCases(int sumCases) {
        this.sumCases = sumCases;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "CountryCase{" +
                "country='" + country + '\'' +
                ", population=" + population +
                ", sumCases=" + sumCases +
                ", counter=" + counter +
                '}';
    }
}
