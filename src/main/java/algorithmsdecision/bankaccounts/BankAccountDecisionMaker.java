package algorithmsdecision.bankaccounts;

import java.util.List;

public class BankAccountDecisionMaker {

//    metódus megírása, ami eldönti van-e olyan számla, amelynek az aktuális egyenlege meghaladja a paraméterként kapott alsó határt.
    public boolean containsBalanceGreaterThan(List<BankAccount> bankAccountList, int lowLimit){

        boolean ifExist = false;  ///v ez nem kell, return true, return false
        for (BankAccount ba: bankAccountList){
            if(ba.getBalance()> lowLimit){
                ifExist= true;
                break;
            }
        }
        return ifExist;
    }
}
