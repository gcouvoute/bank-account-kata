package gcouvoute.kata.bankaccountkata.service.impl;

import gcouvoute.kata.bankaccountkata.service.BankClientService;
import gcouvoute.kata.bankaccountkata.service.dtos.BankClientDto;
import org.springframework.stereotype.Service;

@Service
public class BankClientServiceImpl implements BankClientService {

    @Override
    public BankClientDto createClient(String name) {
        return null;
    }

    @Override
    public BankClientDto getClient(String id) {
        return null;
    }

    @Override
    public boolean exist(String id) {
        return false;
    }

    @Override
    public void deleteClient(String id) {
        // TODO implement later
    }
}
