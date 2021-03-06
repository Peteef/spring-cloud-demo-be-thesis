package pl.edu.wfiis.agh.kamilturek.notification.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wfiis.agh.kamilturek.notification.model.Notification;
import pl.edu.wfiis.agh.kamilturek.notification.repository.NotificationRepository;

import java.util.Optional;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationController.class);

    private final NotificationRepository repository;

    @Autowired
    public NotificationController(NotificationRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody Notification notification) {
        LOGGER.info("Adding notification: {}", notification);
        return ResponseEntity.ok(repository.add(notification));
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        LOGGER.info("Notification find: id={}", id);
        Optional optional = repository.findById(id);
        if(optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        LOGGER.info("Notification not exist: id={}", id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity findByAccount(@PathVariable("accountNumber") String accountNumber) {
        LOGGER.info("Notification by account number find: accountNumber={}", accountNumber);
        return ResponseEntity.ok(repository.findByAccountNumber(accountNumber));
    }
}
