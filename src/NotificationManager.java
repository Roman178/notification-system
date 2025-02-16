import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public void sendAll() {
        for (Notification notification: notifications) {
            notification.send();
        }
    }

    public void sendUrgent() {
        notifications.stream()
                .filter(Notification::isUrgent)
                .forEach(Notification::send);
    }

    public void saveAll() {
        for (Notification notification: notifications) {
            notification.save();
        }
    }
}
