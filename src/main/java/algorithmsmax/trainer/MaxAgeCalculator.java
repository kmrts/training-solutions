package algorithmsmax.trainer;

import java.util.List;

public class MaxAgeCalculator {

    //   kikeresi a legidősebb trainert.

    public Trainer trainerWithMaxAge(List<Trainer> trainers){

//        int maxAge= Integer.MIN_VALUE;
        Trainer maxAgeTrainer= null;
        for (Trainer t: trainers){

            if(maxAgeTrainer == null || t.getAge()> maxAgeTrainer.getAge()){   ///
//                maxAge= t.getAge();
                maxAgeTrainer= t;
            }
        }

        return maxAgeTrainer;

    }
}
