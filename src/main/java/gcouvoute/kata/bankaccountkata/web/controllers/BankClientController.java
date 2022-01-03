package gcouvoute.kata.bankaccountkata.web.controllers;

import gcouvoute.kata.bankaccountkata.service.BankClientService;
import gcouvoute.kata.bankaccountkata.web.mappers.BankClientWebMapper;
import gcouvoute.kata.bankaccountkata.web.requests.BankClientCreationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankClientResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class BankClientController implements IBankClientController {

    private final BankClientWebMapper mapper;
    private final BankClientService service;

    @Override
    @PostMapping
    public BankClientResponse createClient(@Valid @RequestBody BankClientCreationRequest request) {
        return mapper.dto2Response(service.createClient(request.getName()));
    }

    @Override
    @GetMapping("/{id}")
    public BankClientResponse getClient(@PathVariable String id) {
        if (!service.exist(id)) {
            throw new IllegalArgumentException("Client not found");
        }
        return mapper.dto2Response(service.getClient(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable String id) {
        if (!service.exist(id)) {
            throw new IllegalArgumentException("Client not found");
        }
        service.deleteClient(id);
    }
}
