package algorithmsdecision.bankaccounts;

import java.util.List;

public class TransactionExecution {

//    Készíts egy metódust, amelyik megkap egy tranzakció listát és egy számlák listát paraméterként
//    és végrehajtja az összes tranzakciót, azaz minden tranzakcióhoz megkeresi az érintett számlát és ha megtalálja,
//    akkor a creditOrDebit értéke alapján a számla megfelelő metódusának (withdraw vagy deposit) meghívásával
//    módosítja a számla egyenlegét. Sikeres végrehajtás esetén a tranzakció státuszát állítsd SUCCEEDED-re,
//    különben tedd PENDING-re. Feltételezzük természetesen, hogy a számlaszámok egyediek a számlák listában.

    public void executeTransactions(List<Transaction> transactionList, List<BankAccount> accounts){
        for (Transaction tr: transactionList){
//            String accNum= tr.getAccountNumber();
            for (BankAccount bac: accounts){
                if(bac.getAccountNumber().equals(tr.getAccountNumber())){
                    execTrans(tr, bac);

                }
            }
        }
    }

    public void execTrans(Transaction transaction, BankAccount bankAccount){
        if (transaction.isCredit()) {
            bankAccount.deposit(transaction.getAmount());
            transaction.setExecuted();
        }
        if (transaction.isDebit()){
            if(bankAccount.withdraw(transaction.getAmount())){
                transaction.setExecuted();
            }else{
                transaction.setNotExecuted();
            }
        }
    }
}
