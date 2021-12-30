package gcouvoute.kata.bankaccountkata.web.controllers;

import gcouvoute.kata.bankaccountkata.web.requests.BankOperationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankOperationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Bank Operation", description = "Endpoint to handle operation")
public interface IBankOperationController {

    @Operation(summary = "Make an operation")
    BankOperationResponse makeOperation(String clientId, BankOperationRequest request);

    @Operation(summary = "Get all operations related to the target client")
    List<BankOperationResponse> getOperations(String clientId);
}
