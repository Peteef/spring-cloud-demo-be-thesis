package pl.edu.wfiis.agh.kamilturek.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.edu.wfiis.agh.kamilturek.payment.model.Notification;

@FeignClient(name = "notification-service")
public interface NotificationClient {
    @PostMapping("/notifications/")
    Notification add(@RequestBody Notification notification);
}
