package gcouvoute.kata.bankaccountkata.service.impl;

import gcouvoute.kata.bankaccountkata.service.BankOperationService;
import gcouvoute.kata.bankaccountkata.service.dtos.BankOperationDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BankOperationServiceImpl implements BankOperationService {

    @Override
    public BankOperationDto makeOperation(String clientId, BankOperationDto operation) {
        return null;
    }

    @Override
    public List<BankOperationDto> getOperations(String clientId) {
        return Collections.emptyList();
    }
}
