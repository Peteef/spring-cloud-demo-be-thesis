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

        repository.add(new Account("11222222223333333333333333", 6000.0, "Kamil", "Turek"));
        repository.add(new Account("44555555556666666666666666", 2500.0, "Marcin", "Jaki"));
        repository.add(new Account("77888888889999999999999999", 0.0, "Adam", "Zero"));

        repository.add(new Account("99888888887777777777777777", 15000.60, "Michal", "Bogacz"));
        repository.add(new Account("66555555554444444444444444", 3855.19, "Anna", "Nowak"));
        repository.add(new Account("33222222221111111111111111", 529.11, "Katarzyna", "Herb"));

        return repository;
    }
}
