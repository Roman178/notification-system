import java.time.LocalDateTime;

public class PushNotification extends Notification {
    String deviceId;

    public PushNotification(
            String recipient,
            String message,
            Priority priority,
            LocalDateTime scheduleTime,
            String deviceId) {
        super(recipient, message, priority, scheduleTime);
        this.deviceId = deviceId;
    }

    @Override
    protected void send() {
        System.out.println("\uD83D\uDD14 Отправлено push-уведомление на устройство " + deviceId +": " + message);
    }
}
