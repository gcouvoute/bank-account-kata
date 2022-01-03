package gcouvoute.kata.bankaccountkata.web.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BankClientCreationRequest {

    @NotBlank(message = "Empty name")
    String name;
}
