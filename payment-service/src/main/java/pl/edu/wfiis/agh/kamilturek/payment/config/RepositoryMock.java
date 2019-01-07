package pl.edu.wfiis.agh.kamilturek.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wfiis.agh.kamilturek.payment.reporitory.PaymentRepository;

@Configuration
public class RepositoryMock {
    @Bean
    PaymentRepository repository() {
        PaymentRepository repository = new PaymentRepository();
        return repository;
    }
}
