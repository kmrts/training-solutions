package algorithmsdecision.bankaccounts;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TransactionExecutionTest {

    List<BankAccount> accounts = Arrays.asList(
            new BankAccount("Fred", "123-324-123", 100),
            new BankAccount("Kate", "133-324-123", 2000),
            new BankAccount("Mary", "143-324-123", 90)
    );

    List<Transaction> transactions = Arrays.asList(
            new Transaction("123-324-123", TransactionOperation.CREDIT, 2000, LocalDateTime.MIN),
            new Transaction("133-324-123", TransactionOperation.DEBIT, 200, LocalDateTime.MIN),
            new Transaction("143-324-123", TransactionOperation.DEBIT, 2000, LocalDateTime.MIN)
    );

    TransactionExecution test = new TransactionExecution();

    @Test
    public void testExecuteBankAccountCredit() {

        test.executeTransactions(transactions, accounts);
        assertEquals(2100, accounts.get(0).getBalance());

    }

    @Test
    public void testExecuteBankAccountDebitWithDrawOk() {

        test.executeTransactions(transactions, accounts);
        assertEquals(1800, accounts.get(1).getBalance());

    }

    @Test
    public void testExecuteBankAccountDebitWithDrawNotOk() {

        test.executeTransactions(transactions, accounts);
        assertEquals(90, accounts.get(2).getBalance());

    }

    @Test   /// saj.
    public void testExecuteDebitNotOkStatus() {

        test.executeTransactions(transactions, accounts);
        assertEquals("PENDING", transactions.get(2).getStatus().toString());   //toString() nélkül nem ok

    }

}
