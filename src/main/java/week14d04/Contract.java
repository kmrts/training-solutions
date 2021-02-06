package week14d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {
    /*
    van egy String client és egy List<Integer> monthlyPrices attribútuma.
    Az előbbi a szerződő neve, a második pedig a havonta
fizetendő összeg.
     */
    private String client;
    private List<Integer> monthlyPrices= new ArrayList<>();

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public String getClient() {
        return client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;//new ArrayList<>(monthlyPrices);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "client='" + client + '\'' +
                ", monthlyPrices=" + monthlyPrices +
                '}';
    }
}
