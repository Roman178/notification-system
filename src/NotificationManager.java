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

    public void sendAll(NotificationLogger logger) {
        for (Notification notification: notifications) {
            if (notification.isReadyToSend()) {
                notification.send();
                logger.addLog(notification.createLog());
            } else {
                System.out.println(notification.messageWasNotSent());
            }
        }
    }

    public void sendUrgent() {
        notifications.stream()
                .filter(Notification::isUrgent)
                .forEach(Notification::send);
    }

    public void sendUrgent(NotificationLogger logger) {
        notifications.stream()
                .filter(Notification::isUrgent)
                .forEach(note -> {
                    if (note.isReadyToSend()) {
                        note.send();
                        logger.addLog(note.createLog());
                    } else {
                        System.out.println(note.messageWasNotSent());
                    }
                });
    }

    public void saveAll() {
        for (Notification notification: notifications) {
            notification.save();
        }
    }

    public void saveLogsToFile() {
        for (Notification notification: notifications) {
            notification.saveLogsToFile();
        }
    }
}
