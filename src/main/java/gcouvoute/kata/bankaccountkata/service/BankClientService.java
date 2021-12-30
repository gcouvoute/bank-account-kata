package gcouvoute.kata.bankaccountkata.service;

import gcouvoute.kata.bankaccountkata.service.dtos.BankClientDto;

/**
 * Service to interact at client level
 */
public interface BankClientService {

    /**
     * Method to create a client
     *
     * @param name The name of the future client
     * @return The client info
     */
    BankClientDto createClient(String name);

    /**
     * Method to retrieve info about a specific client
     *
     * @param id The id of the client
     * @return The client info
     */
    BankClientDto getClient(String id);

    /**
     * Method to know if a client exist for this id
     *
     * @param id The id of the client
     * @return true if client exist, otherwise false
     */
    boolean exist(String id);

    /**
     * Method to delete a client
     *
     * @param id The id of the client
     */
    void deleteClient(String id);
}
