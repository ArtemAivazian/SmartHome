package cz.cvut.fel.omo.homeworks.refactor.transaction;

import java.util.Optional;

public abstract class AbstractTransactionSystem implements TransactionSystem{

    protected Long totalAmount;
    protected String currencyCode;

    protected AbstractTransactionSystem(Long totalAmount, String currencyCode) {
        this.totalAmount = totalAmount;
        this.currencyCode = currencyCode;
    }

    @Override
    public String executeTransaction() {
        //a Template Method pseudocode
        Optional<String> transaction = buildTransaction();
        return transaction.isPresent() ? (execute(String.valueOf(transaction))).get() : "Transaction execution failed.";
    }

    protected abstract Optional<String> execute(String transaction);
    protected abstract Optional<String> buildTransaction();
}
