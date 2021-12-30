package gcouvoute.kata.bankaccountkata.service.mappers;

import gcouvoute.kata.bankaccountkata.datasource.entities.OperationEntity;
import gcouvoute.kata.bankaccountkata.service.dtos.BankOperationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankOperationMapper {

    BankOperationDto entity2Dto(OperationEntity operation);

    List<BankOperationDto> entities2Dto(List<OperationEntity> operations);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "client", ignore = true)
    OperationEntity dto2Entity(BankOperationDto operation);
}
