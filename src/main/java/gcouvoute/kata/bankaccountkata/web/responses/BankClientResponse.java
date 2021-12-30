package gcouvoute.kata.bankaccountkata.web.responses;

import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

@With
@Value
public class BankClientResponse {

    String id;
    String name;
    Status status;
    int balance;
    LocalDateTime creationDate;
    LocalDateTime modificationDate;
    LocalDateTime deletionDate;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
