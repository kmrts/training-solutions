package algorithmscount.bankaccounts;

import java.util.List;

public class TransactionCounter {

    public int countEntryLessThan(List<Transaction> transactionList, int limit){

        int counter= 0;
        for (Transaction trItem: transactionList){
            if (trItem.getAmount()<limit){
                counter++;
            }
        }
        return counter;
    }


}
