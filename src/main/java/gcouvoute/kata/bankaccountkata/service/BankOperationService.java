package gcouvoute.kata.bankaccountkata.service;

import gcouvoute.kata.bankaccountkata.service.dtos.BankOperationDto;

import java.util.List;

/**
 * Service to interact at operation level
 */
public interface BankOperationService {

    /**
     * Method to make an operation on a specific account
     *
     * @param clientId  The id of the client
     * @param operation The operation to make
     * @return The operation made
     */
    BankOperationDto makeOperation(String clientId, BankOperationDto operation);

    /**
     * Method to get all operation related to a client
     *
     * @param clientId The id of the client
     * @return List of operations
     */
    List<BankOperationDto> getOperations(String clientId);
}
