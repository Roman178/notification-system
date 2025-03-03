import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Notification implements Storable {
    String recipient;
    String message;
    Priority priority;
//    LocalDateTime timestamp = LocalDateTime.now();
    LocalDateTime scheduleTime;

    public Notification(String recipient,
                        String message,
                        Priority priority,
                        LocalDateTime scheduleTime) {
        this.recipient = recipient;
        this.message = message;
        this.priority = priority;
        this.scheduleTime = scheduleTime;
    }

    private void setScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    public boolean isReadyToSend() {
        return scheduleTime == null || scheduleTime.isBefore(LocalDateTime.now());
    }

    protected abstract void send();

    public void sendNotification() {
        if (scheduleTime == null) {
            setScheduleTime(LocalDateTime.now());
        }
        send();
    }

    public String createLog() {
        return "(" + priority + ") " + "Уведомление для " + recipient + ": " + message + " [отправлено в " + scheduleTime + "]";
    }

    public String messageWasNotSent() {
        DateTimeFormatter ruFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        return "Сообщение '" + message + "' для " + recipient + " не отправлено. Будет отправлено: " + scheduleTime.format(ruFormat);
    }

    public boolean isUrgent() {
        return priority.equals(Priority.HIGH);
    }

    @Override
    public void save() {
        System.out.println("💾 Уведомление сохранено в БД: " + message);
    }

    @Override
    public void saveLogsToFile() {
        try(FileWriter writer = new FileWriter("logs.txt", true)) {
            String log = createLog() + "\n";
            writer.write(log);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
