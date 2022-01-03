package gcouvoute.kata.bankaccountkata.service.impl;

import gcouvoute.kata.bankaccountkata.datasource.entities.ClientEntity;
import gcouvoute.kata.bankaccountkata.datasource.repositories.ClientRepository;
import gcouvoute.kata.bankaccountkata.service.BankClientService;
import gcouvoute.kata.bankaccountkata.service.dtos.BankClientDto;
import gcouvoute.kata.bankaccountkata.service.mappers.BankClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BankClientServiceImpl implements BankClientService {

    private final BankClientMapper mapper;
    private final ClientRepository repository;

    @Override
    @Transactional
    public BankClientDto createClient(String name) {
        ClientEntity client = new ClientEntity();
        client.setId(UUID.randomUUID().toString());
        client.setName(name);
        client.setStatus(ClientEntity.Status.ACTIVE);
        client.setBalance(0);
        client.setCreationDate(LocalDateTime.now());

        return mapper.entity2Dto(repository.save(client));
    }

    @Override
    public BankClientDto getClient(String id) {
        return mapper.entity2Dto(repository.getById(id));
    }

    @Override
    public boolean exist(String id) {
        return repository.existsByIdAndStatus(id, ClientEntity.Status.ACTIVE);
    }

    @Override
    @Transactional
    public void deleteClient(String id) {
        ClientEntity client = repository.getById(id);
        client.setStatus(ClientEntity.Status.INACTIVE);
        client.setBalance(0);
        client.setDeletionDate(LocalDateTime.now());
    }
}
