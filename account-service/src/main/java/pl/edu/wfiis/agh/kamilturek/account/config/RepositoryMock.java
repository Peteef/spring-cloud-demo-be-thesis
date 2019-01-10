package pl.edu.wfiis.agh.kamilturek.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.edu.wfiis.agh.kamilturek.account.model.Account;
import pl.edu.wfiis.agh.kamilturek.account.repository.AccountRepository;

@Configuration
public class RepositoryMock {
    @Bean
    AccountRepository repository() {
        AccountRepository repository = new AccountRepository();
        repository.add(new Account("123", 100.0, "Kamil", "Turek"));
        repository.add(new Account("456", 300.0, "Marcin", "Jaki"));
        repository.add(new Account("789", 0.0, "Adam", "Opek"));
        return repository;
    }
}
