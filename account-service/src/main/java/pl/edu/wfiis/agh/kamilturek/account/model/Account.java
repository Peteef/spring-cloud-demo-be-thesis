package pl.edu.wfiis.agh.kamilturek.account.model;

import java.util.Objects;

public class Account {
    private String accountNumber;
    private Double value;
    private String firstname;
    private String lastname;

    public Account(String accountNumber, Double value, String firstname, String lastname) {
        this.accountNumber = accountNumber;
        this.value = value;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getValue() {
        return value;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", value=" + value +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accountNumber.equals(account.accountNumber) &&
                value.equals(account.value) &&
                firstname.equals(account.firstname) &&
                lastname.equals(account.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, value, firstname, lastname);
    }
}
