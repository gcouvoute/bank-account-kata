package gcouvoute.kata.bankaccountkata.web.mappers;

import gcouvoute.kata.bankaccountkata.service.dtos.BankClientDto;
import gcouvoute.kata.bankaccountkata.web.responses.BankClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankClientWebMapper {

    BankClientResponse dto2Response(BankClientDto dto);
}
