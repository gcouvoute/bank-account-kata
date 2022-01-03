package gcouvoute.kata.bankaccountkata.web.requests;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class BankOperationRequest {

    Operation operation;
    @Min(value = 0, message = "Negative amount not allowed")
    int amount;

    public enum Operation {
        DEPOSIT, WITHDRAWAL
    }
}
