package pl.edu.wfiis.agh.kamilturek.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "account-service")
public interface AccountClient {
    @GetMapping("/accounts/{accountNumber}")
    ResponseEntity findByAccountNumber(@PathVariable("accountNumber") String accountNumber);

    @PutMapping("/accounts/{accountNumber}/credit/{value}")
    ResponseEntity credit(
            @PathVariable("accountNumber") String accountNumber,
            @PathVariable("value") Double value
    );

    @PutMapping("/accounts/{accountNumber}/debit/{value}")
    ResponseEntity debit(
            @PathVariable("accountNumber") String accountNumber,
            @PathVariable("value") Double value
    );
}
