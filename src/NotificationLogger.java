import java.util.ArrayList;
import java.util.List;

public class NotificationLogger {
    List<String> logs = new ArrayList<>();

    public void addLog(String log) {
        logs.add(log);
    }

    public void printLogs() {
        printLogs(logs.size());
    }

    public void printLogs(int numberOfRecentLogs) {
        StringBuilder printedLogs = new StringBuilder("LOGS: \n");

        for (int i = logs.size() - 1; i >= (logs.size() - numberOfRecentLogs); i--) {
            printedLogs.append(logs.get(i)).append("\n");
        }

        System.out.println(printedLogs);
    }
}
