package pl.edu.wfiis.agh.kamilturek.account.repository;

import pl.edu.wfiis.agh.kamilturek.account.exception.CouldNotProcessValueException;
import pl.edu.wfiis.agh.kamilturek.account.model.Account;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AccountRepository {
    private List<Account> accounts = new LinkedList<>();

    public Account add(Account account) {
        accounts.add(account);
        return account;
    }

    public Optional<Account> findByAccountNumber(String accountNumber) {
        return accounts.stream()
                       .filter(notification -> notification.getAccountNumber().equals(accountNumber))
                       .findFirst();
    }

    public Account credit(String accountNumber, Double value) {
        Optional<Account> account = findByAccountNumber(accountNumber);
        if(account.isPresent() && value > 0) {
            accounts.forEach(
                    acc -> {
                        if(acc.equals(account.get())) {
                            acc.setValue(acc.getValue() + value);
                        }
                    }
            );
            return account.get();
        }
        throw new CouldNotProcessValueException("Could not credit. Account with number: " + accountNumber + " does not exist.");
    }

    public Account debit(String accountNumber, Double value) {
        Optional<Account> account = findByAccountNumber(accountNumber);
        if(account.isPresent() && value > 0) {
            accounts.forEach(
                    acc -> {
                        if(acc.equals(account.get())) {
                            if(acc.getValue() - value < 0) {
                                throw new CouldNotProcessValueException("Could not debit. Account with number: " + accountNumber + " has not enough values.");
                            }
                            acc.setValue(acc.getValue() - value);
                        }
                    }
            );
            return account.get();
        }
        throw new CouldNotProcessValueException("Could not debit. Account with number: " + accountNumber + " does not exist.");
    }
}
