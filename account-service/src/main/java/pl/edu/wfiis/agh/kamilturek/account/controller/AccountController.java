package pl.edu.wfiis.agh.kamilturek.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wfiis.agh.kamilturek.account.exception.CouldNotProcessValueException;
import pl.edu.wfiis.agh.kamilturek.account.model.Account;
import pl.edu.wfiis.agh.kamilturek.account.repository.AccountRepository;

import java.util.Optional;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    private final AccountRepository repository;

    @Autowired
    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody Account account) {
        LOGGER.info("Adding account: {}", account);
        return ResponseEntity.ok(repository.add(account));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity findByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        LOGGER.info("Account find: id={}", accountNumber);
        Optional optional = repository.findByAccountNumber(accountNumber);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{accountNumber}/credit/{value}")
    public ResponseEntity credit(
            @PathVariable("accountNumber") String accountNumber,
            @PathVariable("value") Double value
    ) {
        LOGGER.info("Credit account: accountNumber={}", accountNumber);
        try {
            return ResponseEntity.ok(repository.credit(accountNumber, value));
        } catch(CouldNotProcessValueException e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{accountNumber}/debit/{value}")
    public ResponseEntity debit(
            @PathVariable("accountNumber") String accountNumber,
            @PathVariable("value") Double value
    ) {
        LOGGER.info("Debit account: accountNumber={}", accountNumber);
        try {
            return ResponseEntity.ok(repository.debit(accountNumber, value));
        } catch(CouldNotProcessValueException e) {
            LOGGER.error(e.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}
