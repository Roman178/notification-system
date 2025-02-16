import java.time.LocalDateTime;

public abstract class Notification implements Storable {
    String recipient;
    String message;
    Priority priority;
    LocalDateTime timestamp;

    public Notification(String recipient,
                        String message,
                        Priority priority,
                        LocalDateTime timestamp) {
        this.recipient = recipient;
        this.message = message;
        this.priority = priority;
        this.timestamp = timestamp;
    }

    public abstract void send();

    public void log() {
        System.out.println("(" + priority + ") " + "Уведомление для " + recipient + ": " + message + " [отправлено в " + timestamp + "]");
    }

    public boolean isUrgent() {
        return priority.equals(Priority.HIGH);
    }

    @Override
    public void save() {
        System.out.println("💾 Уведомление сохранено в БД: " + message);
    }
}
