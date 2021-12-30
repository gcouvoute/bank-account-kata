package gcouvoute.kata.bankaccountkata.web.requests;

import lombok.Value;
import lombok.With;

@With
@Value
public class BankOperationRequest {

    Operation operation;
    int amount;

    public enum Operation {
        DEPOSIT, WITHDRAWAL
    }
}
