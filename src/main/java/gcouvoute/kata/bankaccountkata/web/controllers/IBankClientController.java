package gcouvoute.kata.bankaccountkata.web.controllers;

import gcouvoute.kata.bankaccountkata.web.requests.BankClientCreationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankClientResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bank Client", description = "Endpoint to manage clients")
public interface IBankClientController {

    @Operation(summary = "Create a client")
    BankClientResponse createClient(BankClientCreationRequest request);

    @Operation(summary = "Get a client by its id")
    BankClientResponse getClient(String id);

    @Operation(summary = "Remove a client by its id")
    void deleteClient(String id);
}
