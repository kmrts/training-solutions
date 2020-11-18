package algorithmsdecision.bankaccounts;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDecisionMaker {
    //    Feladat egy metódus megírása, ami eldönti van-e olyan terhelés (debit) tranzakció egy adott dátum intervallumon belül,
//    amely egy adott összeghatárnál nagyobb.

    public boolean containsCreditEntryGreaterThan(List<Transaction> transactionList, LocalDateTime startDate, LocalDateTime endDate, int limit){
        for (Transaction transItem: transactionList){
            if (transItem.getTransactionOperation()== TransactionOperation.DEBIT
                    && transItem.getDateOfTransaction().isAfter(startDate) && transItem.getDateOfTransaction().isBefore(endDate)
                    && transItem.getAmount()> limit){
                return true;
            }
        }
        return false;
    }
}
