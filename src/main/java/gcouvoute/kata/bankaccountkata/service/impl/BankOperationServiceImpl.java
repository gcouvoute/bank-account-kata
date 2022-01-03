package gcouvoute.kata.bankaccountkata.service.impl;

import gcouvoute.kata.bankaccountkata.datasource.entities.ClientEntity;
import gcouvoute.kata.bankaccountkata.datasource.entities.OperationEntity;
import gcouvoute.kata.bankaccountkata.datasource.repositories.ClientRepository;
import gcouvoute.kata.bankaccountkata.datasource.repositories.OperationRepository;
import gcouvoute.kata.bankaccountkata.service.BankOperationService;
import gcouvoute.kata.bankaccountkata.service.dtos.BankOperationDto;
import gcouvoute.kata.bankaccountkata.service.mappers.BankOperationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankOperationServiceImpl implements BankOperationService {

    private final BankOperationMapper mapper;
    private final OperationRepository repository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public BankOperationDto makeOperation(String clientId, BankOperationDto operation) {
        ClientEntity clientEntity = clientRepository.getById(clientId);

        if (BankOperationDto.Operation.WITHDRAWAL.equals(operation.getOperation()) &&
                clientEntity.getBalance() - operation.getAmount() < 0) {
            throw new IllegalArgumentException("Negative balance not allowed");
        }
        OperationEntity entity = mapper.dto2Entity(operation);
        entity.setId(UUID.randomUUID().toString());
        entity.setDate(LocalDateTime.now());
        entity.setClient(clientEntity);
        entity.setBalance(BankOperationDto.Operation.WITHDRAWAL.equals(operation.getOperation()) ?
                clientEntity.getBalance() - operation.getAmount() : clientEntity.getBalance() + operation.getAmount());

        clientEntity.setBalance(entity.getBalance());
        clientEntity.setModificationDate(LocalDateTime.now());
        clientRepository.save(clientEntity);

        return mapper.entity2Dto(repository.save(entity));
    }

    @Override
    public List<BankOperationDto> getOperations(String clientId) {
        return mapper.entities2Dto(repository.findAllByClientId(clientId));
    }
}
