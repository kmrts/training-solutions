package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class ListOfGoodPubs {

    private List<Pub> goodPubs = new ArrayList<>();

    public ListOfGoodPubs(List<Pub> goodPubs) {
        if (goodPubs.isEmpty()) {
            throw new IllegalArgumentException("Pub list is empty!");
        }
        this.goodPubs = goodPubs;
    }

    public Pub findTheBest() {
        int winner = 86400; // 24*60*60
        Pub winnerPub = goodPubs.get(0);

        for (Pub p : goodPubs) {
            int actualSec = p.getOpenFrom().toSeconds();  //3.toSec. nélkül ez: p.getOpenFrom().toSeconds(p.getOpenFrom())
            if (actualSec < winner) {
                winnerPub = p;
                winner = actualSec;
            }
        }
        return winnerPub;

    }
}

