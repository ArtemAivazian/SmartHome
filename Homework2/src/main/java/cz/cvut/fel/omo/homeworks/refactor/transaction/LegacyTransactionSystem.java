package cz.cvut.fel.omo.homeworks.refactor.transaction;

import cz.cvut.fel.omo.homeworks.common.client.LegacyPaymentClient;
import cz.cvut.fel.omo.homeworks.common.session.UserSession;

import java.util.Optional;

public class LegacyTransactionSystem extends AbstractTransactionSystem{
    private final LegacyPaymentClient legacyPaymentClient = new LegacyPaymentClient();
    private final UserSession userSession = new UserSession();
    public LegacyTransactionSystem(Long totalAmount, String currencyCode) {
        super(totalAmount, currencyCode);
    }

    @Override
    protected Optional<String> execute(String transaction) {
        return Optional.of(legacyPaymentClient.execute(transaction, userSession.getIP()));
    }

    @Override
    protected Optional<String> buildTransaction() {
        if (currencyCode == null || totalAmount == null) {
            return Optional.empty();
        }
        return Optional.of(String.join(";", currencyCode, totalAmount.toString()));
    }
}