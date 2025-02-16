import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();

        Notification emailNotification = new EmailNotification(
                "Peter",
                "hi Peter my dear friend",
                Priority.HIGH,
                LocalDateTime.now(),
                "examle@example.com");

        Notification smsNotification = new SMSNotification(
                "Sky",
                "hi Sky, how's it going",
                Priority.MEDIUM,
                LocalDateTime.now(),
                "45 34 45 434");

        Notification pushNotification = new PushNotification(
                "Bob",
                "Hi Bob! Is your lastname Marley?",
                Priority.HIGH,
                LocalDateTime.now(),
                "45");

        notificationManager.addNotification(emailNotification);
        notificationManager.addNotification(smsNotification);
        notificationManager.addNotification(pushNotification);

//        notificationManager.sendAll();
        notificationManager.sendUrgent();
        notificationManager.saveAll();
    }
}