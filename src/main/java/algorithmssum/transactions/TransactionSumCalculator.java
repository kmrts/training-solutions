package algorithmssum.transactions;

import java.util.List;


public class TransactionSumCalculator {

    public int sumAmountOfCreditEntries(List<Transaction> transactions){
        int sum= 0;

        for (Transaction tItem: transactions){
            if(tItem.isCredit()){  //
                sum+=tItem.getAmount();
            }
        }
        return sum;
    }
}
