import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager();
        NotificationLogger logger = new NotificationLogger();

        Notification emailNotification = new EmailNotification(
                "Peter",
                "hi Peter my dear friend",
                Priority.HIGH,
                null,
                "examle@example.com");

        Notification smsNotification = new SMSNotification(
                "Sky",
                "hi Sky, how's it going",
                Priority.MEDIUM,
                LocalDateTime.of(2025, 2, 17, 22, 40),
                "45 34 45 434");

        Notification pushNotification = new PushNotification(
                "Bob",
                "Hi Bob! Is your lastname Marley?",
                Priority.HIGH,
                null,
                "45");

        notificationManager.addNotification(emailNotification);
        notificationManager.addNotification(smsNotification);
        notificationManager.addNotification(pushNotification);

        notificationManager.sendAll(logger);
//        notificationManager.sendUrgent(logger);
        notificationManager.saveLogsToFile();

        logger.printLogs();
//        logger.printLogs(2);
    }
}