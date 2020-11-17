package algorithmscount.bankaccounts;

import java.util.List;

public class BankAccountConditionCounter {

    public int countWithBalanceGreaterThan(List<BankAccount> bankAccounts, int limit){
        int sum=0;
        for (BankAccount bac: bankAccounts){
            if(bac.getBalance()>limit){
                sum++;
            }
        }
        return sum;
    }
}
