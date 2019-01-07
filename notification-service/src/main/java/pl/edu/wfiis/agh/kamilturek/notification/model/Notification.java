package pl.edu.wfiis.agh.kamilturek.notification.model;

import java.util.Objects;

public class Notification {
    private Integer id;
    private Integer accountId;
    private String text;

    public Notification(Integer accountId, String text) {
        this.accountId = accountId;
        this.text = text;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(id, that.id) &&
                accountId.equals(that.accountId) &&
                text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, text);
    }
}
