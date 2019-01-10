package pl.edu.wfiis.agh.kamilturek.payment.model;

import java.util.Objects;

public class Notification {
    private Integer id;
    private String accountNumber;
    private String text;

    public Notification(String accountNumber, String text) {
        this.accountNumber = accountNumber;
        this.text = text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) &&
                accountNumber.equals(that.accountNumber) &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountNumber, text);
    }
}
