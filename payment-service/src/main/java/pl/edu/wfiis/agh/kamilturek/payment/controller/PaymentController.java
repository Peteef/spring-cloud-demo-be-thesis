package pl.edu.wfiis.agh.kamilturek.payment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wfiis.agh.kamilturek.payment.model.Payment;
import pl.edu.wfiis.agh.kamilturek.payment.reporitory.PaymentRepository;

import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentRepository repository;

    @Autowired
    public PaymentController(PaymentRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public ResponseEntity perform(@RequestBody Payment payment) {
        LOGGER.info("Performing payment: {}", payment);
        //Code
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        LOGGER.info("Payment find: id={}", id);
        Optional optional = repository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/senders/{accountNumber}")
    public ResponseEntity findBySender(@PathVariable("accountNumber") String accountNumber) {
        LOGGER.info("Payment find by sender: accountNumber={}", accountNumber);
        return ResponseEntity.ok(repository.findBySender(accountNumber));
    }

    @GetMapping("/receivers/{accountNumber}")
    public ResponseEntity findByReceiver(@PathVariable("accountNumber") String accountNumber) {
        LOGGER.info("Payment find by receiver: accountNumber={}", accountNumber);
        return ResponseEntity.ok(repository.findBySender(accountNumber));
    }
}
