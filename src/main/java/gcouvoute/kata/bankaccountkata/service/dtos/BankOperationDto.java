package gcouvoute.kata.bankaccountkata.service.dtos;

import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

@With
@Value
public class BankOperationDto {

    Operation operation;
    LocalDateTime date;
    int amount;
    int balance;

    public enum Operation {
        DEPOSIT, WITHDRAWAL
    }
}
