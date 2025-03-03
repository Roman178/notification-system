import java.time.LocalDateTime;

public class EmailNotification extends Notification {
    String emailAddress;

    public EmailNotification(String recipient,
                             String message,
                             Priority priority,
                             LocalDateTime scheduleTime,
                             String emailAddress) {
        super(recipient, message, priority, scheduleTime);
        this.emailAddress = emailAddress;
    }

    @Override
    protected void send() {
        StringBuilder msg = new StringBuilder( "\uD83D\uDCE7 Отправлено email на ")
                .append(emailAddress)
                .append(": ")
                .append(message);
        if (isUrgent()) {
            msg.insert(0, "⚠ Важное сообщение! ");
        }
        System.out.println(msg);
    }
}