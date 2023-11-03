package cz.cvut.fel.omo.homeworks.refactor.transaction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.cvut.fel.omo.homeworks.common.client.ModernPaymentClient;
import cz.cvut.fel.omo.homeworks.common.model.ModernTransaction;

import java.util.Optional;
import java.util.UUID;

public class ModernTransactionSystem extends AbstractTransactionSystem{

    private final ModernPaymentClient modernPaymentClient = new ModernPaymentClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    private String furl;
    private String surl;
    public ModernTransactionSystem(Long totalAmount, String currencyCode, String furl, String surl) {
        super(totalAmount, currencyCode);
        this.furl = furl;
        this.surl = surl;
    }

    @Override
    protected Optional<String> execute(String transaction) {
        return Optional.of(modernPaymentClient.execute(transaction));
    }

    @Override
    protected Optional<String> buildTransaction() {
        if (currencyCode == null || totalAmount == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(objectMapper.writeValueAsString(new ModernTransaction()
                    .withExtOrderId(String.valueOf(UUID.randomUUID()))
                    .withTotalAmount(totalAmount)
                    .withCurrencyCode(currencyCode)
                    .withSurl(surl)
                    .withFurl(furl))
                    );
        } catch (JsonProcessingException e) {
            return Optional.empty();
        }
    }

}
