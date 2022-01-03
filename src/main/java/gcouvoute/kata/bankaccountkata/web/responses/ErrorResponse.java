package gcouvoute.kata.bankaccountkata.web.responses;

import lombok.Value;
import lombok.With;

@With
@Value
public class ErrorResponse {

    String cause;
}
