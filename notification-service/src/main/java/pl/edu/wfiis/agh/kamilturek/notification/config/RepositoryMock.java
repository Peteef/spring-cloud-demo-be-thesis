package pl.edu.wfiis.agh.kamilturek.notification.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wfiis.agh.kamilturek.notification.repository.NotificationRepository;

@Configuration
public class RepositoryMock {
    @Bean
    NotificationRepository repository() {
        NotificationRepository repository = new NotificationRepository();
        return repository;
    }
}
