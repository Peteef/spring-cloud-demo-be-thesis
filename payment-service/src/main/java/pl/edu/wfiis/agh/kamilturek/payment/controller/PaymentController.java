package pl.edu.wfiis.agh.kamilturek.payment.controller;

import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wfiis.agh.kamilturek.payment.client.AccountClient;
import pl.edu.wfiis.agh.kamilturek.payment.client.NotificationClient;
import pl.edu.wfiis.agh.kamilturek.payment.model.Notification;
import pl.edu.wfiis.agh.kamilturek.payment.model.Payment;
import pl.edu.wfiis.agh.kamilturek.payment.repository.PaymentRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentRepository repository;

    private final AccountClient accountClient;

    private final NotificationClient notificationClient;

    @Autowired
    public PaymentController(
            PaymentRepository repository,
            AccountClient accountClient,
            NotificationClient notificationClient
    ) {
        this.repository = repository;
        this.accountClient = accountClient;
        this.notificationClient = notificationClient;
    }

    @PostMapping("/")
    public ResponseEntity perform(@RequestBody Payment payment) {
        LOGGER.info("Performing payment: {}", payment);
        payment.setTimestamp(Timestamp.from(Instant.now()));

        try {
            doTransfer(payment);
        } catch (FeignException e) {
            sendPaymentFailureNotification(payment);
            LOGGER.info("Could not perform payment: {}", payment);
            return ResponseEntity.notFound().build();
        }

        repository.add(payment);
        sendPaymentSuccessNotification(payment);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        LOGGER.info("Payment find: id={}", id);
        Optional optional = repository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        LOGGER.info("Payment not exist: id={}", id);
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

    private void doTransfer(Payment payment) {
        accountClient.findByAccountNumber(payment.getReceiverAccountNumber());
        accountClient.debit(payment.getSenderAccountNumber(), payment.getValue());
        accountClient.credit(payment.getReceiverAccountNumber(), payment.getValue());
    }

    private void sendPaymentFailureNotification(Payment payment) {
        notificationClient.add(
                new Notification(
                        payment.getSenderAccountNumber(),
                        payment.getTimestamp() +
                                " Could not perform payment titled " +
                                payment.getTitle() +
                                " for " +
                                payment.getValue() +
                                " to " +
                                payment.getReceiverAccountNumber()
                )
        );
    }

    private void sendPaymentSuccessNotification(Payment payment) {
        notificationClient.add(
                new Notification(
                        payment.getSenderAccountNumber(),
                        payment.getTimestamp() +
                                " Performed payment titled " +
                                payment.getTitle() +
                                " for " +
                                payment.getValue() +
                                " to " +
                                payment.getReceiverAccountNumber()
                )
        );

        notificationClient.add(
                new Notification(
                        payment.getReceiverAccountNumber(),
                        payment.getTimestamp() +
                                " Received payment titled " +
                                payment.getTitle() +
                                " for " +
                                payment.getValue() +
                                " from " +
                                payment.getSenderAccountNumber()
                )
        );
    }
}
