package pl.edu.wfiis.agh.kamilturek.payment.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Payment {
    private Integer id;
    private Timestamp timestamp;
    private String title;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private Double value;

    public Payment(Timestamp timestamp, String title, String senderAccountNumber, String receiverAccountNumber, Double value) {
        this.timestamp = timestamp;
        this.title = title;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.value = value;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getTitle() {
        return title;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", title='" + title + '\'' +
                ", senderAccountNumber='" + senderAccountNumber + '\'' +
                ", receiverAccountNumber='" + receiverAccountNumber + '\'' +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) &&
                Objects.equals(timestamp, payment.timestamp) &&
                title.equals(payment.title) &&
                senderAccountNumber.equals(payment.senderAccountNumber) &&
                receiverAccountNumber.equals(payment.receiverAccountNumber) &&
                value.equals(payment.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, title, senderAccountNumber, receiverAccountNumber, value);
    }
}
