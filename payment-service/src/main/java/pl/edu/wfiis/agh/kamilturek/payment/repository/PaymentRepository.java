package pl.edu.wfiis.agh.kamilturek.payment.repository;

import pl.edu.wfiis.agh.kamilturek.payment.model.Payment;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PaymentRepository {
    private List<Payment> payments = new LinkedList<>();
    private Integer idSequence = 0;

    public Payment add(Payment payment) {
        payment.setId(++idSequence);
        payments.add(payment);
        return payment;
    }

    public Optional<Payment> findById(Integer id) {
        return payments.stream()
                       .filter(payment -> payment.getId().equals(id))
                       .findFirst();
    }

    public List<Payment> findBySender(String accountNumber) {
        return payments.stream()
                       .filter(sender -> sender.getSenderAccountNumber().equals(accountNumber))
                       .collect(Collectors.toList());
    }

    public List<Payment> findByReceiver(String accountNumber) {
        return payments.stream()
                       .filter(sender -> sender.getReceiverAccountNumber().equals(accountNumber))
                       .collect(Collectors.toList());
    }
}
