package pl.edu.wfiis.agh.kamilturek.notification.repository;

import pl.edu.wfiis.agh.kamilturek.notification.model.Notification;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NotificationRepository {
    private List<Notification> notifications = new LinkedList<>();
    private Integer idSequence = 0;

    public Notification add(Notification notification) {
        notification.setId(++idSequence);
        notifications.add(notification);
        return notification;
    }

    public Optional<Notification> findById(Integer id) {
        return notifications.stream()
                            .filter(notification -> notification.getId().equals(id))
                            .findFirst();
    }

    public List<Notification> findByAccountId(Integer accountId) {
        return notifications.stream()
                            .filter(notification -> notification.getAccountId().equals(accountId))
                            .collect(Collectors.toList());
    }
}
