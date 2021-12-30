package gcouvoute.kata.bankaccountkata.web.responses;

import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

@With
@Value
public class BankOperationResponse {

    Operation operation;
    LocalDateTime date;
    int amount;
    int balance;

    public enum Operation {
        DEPOSIT, WITHDRAWAL
    }
}
