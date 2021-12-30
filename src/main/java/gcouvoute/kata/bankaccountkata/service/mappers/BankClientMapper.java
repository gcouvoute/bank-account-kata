package gcouvoute.kata.bankaccountkata.service.mappers;

import gcouvoute.kata.bankaccountkata.datasource.entities.ClientEntity;
import gcouvoute.kata.bankaccountkata.service.dtos.BankClientDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankClientMapper {

    BankClientDto entity2Dto(ClientEntity client);

    @Mapping(target = "operations", ignore = true)
    ClientEntity dto2Entity(BankClientDto client);
}
