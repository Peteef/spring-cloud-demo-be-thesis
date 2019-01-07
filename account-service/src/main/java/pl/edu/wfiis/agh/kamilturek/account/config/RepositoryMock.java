package pl.edu.wfiis.agh.kamilturek.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wfiis.agh.kamilturek.account.repository.AccountRepository;

@Configuration
public class RepositoryMock {
    @Bean
    AccountRepository repository() {
        AccountRepository repository = new AccountRepository();
        return repository;
    }
}
