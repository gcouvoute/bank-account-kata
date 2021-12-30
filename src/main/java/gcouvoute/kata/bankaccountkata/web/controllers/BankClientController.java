package gcouvoute.kata.bankaccountkata.web.controllers;

import gcouvoute.kata.bankaccountkata.web.requests.BankClientCreationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankClientResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class BankClientController implements IBankClientController {

    @Override
    @PostMapping
    public BankClientResponse createClient(BankClientCreationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    @GetMapping("/{id}")
    public BankClientResponse getClient(@PathVariable String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable String id) {
        throw new UnsupportedOperationException();
    }
}
