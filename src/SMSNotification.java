import java.time.LocalDateTime;

public class SMSNotification extends Notification {
    String phoneNumber;

    public SMSNotification(String recipient,
                             String message,
                             Priority priority,
                             LocalDateTime timestamp,
                             String phoneNumber) {
        super(recipient, message, priority, timestamp);
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send() {
        StringBuilder msg = new StringBuilder("\uD83D\uDCF1 Отправлено SMS на ")
                .append(phoneNumber)
                .append(": ")
                .append(message);

        int onceOrTwice = isUrgent() ? 2 : 1;
        for (int i = 0; i < onceOrTwice; i++) {
            System.out.println(msg);
        }
    }
}
