package cz.cvut.fel.omo.homeworks;

import cz.cvut.fel.omo.homeworks.refactor.transaction.ModernTransactionSystem;
import cz.cvut.fel.omo.homeworks.refactor.transaction.TransactionSystem;

public class Main {
    public static void main(String[] args) {
        TransactionSystem modern = new ModernTransactionSystem(1000L, "EUR", "http://fel.cvut.cz/sucess", "http://fel.cvut.cz/sad-smiley");
//        transactionSystem.setTransactionParams(1000L, "CZK");
//        System.out.println(transactionSystem.executeTransaction());

//        transactionSystem.setTransactionParams(1000L, "EUR", "http://fel.cvut.cz/sucess", "http://fel.cvut.cz/sad-smiley");
        System.out.println(modern.executeTransaction());
    }
}