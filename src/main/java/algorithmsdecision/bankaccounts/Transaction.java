package algorithmsdecision.bankaccounts;

import algorithmssum.transactions.TransactionOperation;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private String accountNumber;
    private TransactionOperation transactionOperation;

    private int amount;
    private LocalDateTime dateOfTransaction;
    private TransactionStatus status;

//    Feladat egy metódus megírása, ami eldönti van-e olyan terhelés (debit) tranzakció egy adott dátum intervallumon belül, amely egy adott összeghatárnál nagyobb.

//    A dateOfTransaction attribútum típusa legyen LocalDateTime típusú, mely tárolja a dátumot és az időt.
//    Ennek van egy isAfter() és isBefore() metódusa, mellyel eldönthető, hogy a paraméterként átadott másik dátum előtte vagy utána van-e.

}
