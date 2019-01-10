package pl.edu.wfiis.agh.kamilturek.account.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @GetMapping("/notifications/accounts/{accountNumber}")
    List findByAccount(@PathVariable("accountNumber") String accountNumber);
}
