package gcouvoute.kata.bankaccountkata.web.mappers;

import gcouvoute.kata.bankaccountkata.service.dtos.BankOperationDto;
import gcouvoute.kata.bankaccountkata.web.requests.BankOperationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankOperationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BankOperationWebMapper {

    BankOperationResponse dto2Response(BankOperationDto dto);

    List<BankOperationResponse> dto2Response(List<BankOperationDto> dto);

    @Mapping(target = "date", ignore = true)
    @Mapping(target = "balance", ignore = true)
    BankOperationDto request2Dto(BankOperationRequest request);
}
