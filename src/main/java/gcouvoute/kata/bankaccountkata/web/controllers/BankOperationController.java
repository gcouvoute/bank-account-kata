package gcouvoute.kata.bankaccountkata.web.controllers;

import gcouvoute.kata.bankaccountkata.service.BankClientService;
import gcouvoute.kata.bankaccountkata.service.BankOperationService;
import gcouvoute.kata.bankaccountkata.web.mappers.BankOperationWebMapper;
import gcouvoute.kata.bankaccountkata.web.requests.BankOperationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankOperationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class BankOperationController implements IBankOperationController {

    private final BankOperationWebMapper mapper;
    private final BankOperationService service;
    private final BankClientService clientService;

    @Override
    @PostMapping("/{id}/operation")
    public BankOperationResponse makeOperation(@PathVariable String id, @Valid @RequestBody BankOperationRequest request) {
        if (!clientService.exist(id)) {
            throw new IllegalArgumentException("Client not found");
        }
        return mapper.dto2Response(service.makeOperation(id, mapper.request2Dto(request)));
    }

    @Override
    @GetMapping("/{id}/operations")
    public List<BankOperationResponse> getOperations(@PathVariable String id) {
        if (!clientService.exist(id)) {
            throw new IllegalArgumentException("Client not found");
        }
        return mapper.dto2Response(service.getOperations(id));
    }
}
