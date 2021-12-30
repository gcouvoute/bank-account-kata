package gcouvoute.kata.bankaccountkata.web.controllers;

import gcouvoute.kata.bankaccountkata.web.requests.BankOperationRequest;
import gcouvoute.kata.bankaccountkata.web.responses.BankOperationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class BankOperationController implements IBankOperationController {

    @Override
    @PostMapping("/{id}/operation")
    public BankOperationResponse makeOperation(@PathVariable String id, BankOperationRequest request) {
        throw new UnsupportedOperationException();
    }

    @Override
    @GetMapping("/{id}/operations")
    public List<BankOperationResponse> getOperations(@PathVariable String id) {
        throw new UnsupportedOperationException();
    }
}
