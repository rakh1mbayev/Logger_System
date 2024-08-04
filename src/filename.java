import java.util.*;

class Logger {
    private final HashMap<String, Integer> messageTimestampMap;
    private final Queue<String> messageQueue;
    private static final int TIME_LIMIT = 10;
    private static final int MAX_SIZE = 100;
    public Logger() {
        messageTimestampMap = new HashMap<>();
        messageQueue = new LinkedList<>();
    }
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!messageTimestampMap.containsKey(message) || timestamp - messageTimestampMap.get(message) >= TIME_LIMIT) {
            while (!messageQueue.isEmpty() && timestamp - messageTimestampMap.get(messageQueue.peek()) >= TIME_LIMIT) {
                String oldMessage = messageQueue.poll();
                messageTimestampMap.remove(oldMessage);
            }
            if (messageQueue.size() >= MAX_SIZE) {
                clean(timestamp);
            }
            messageTimestampMap.put(message, timestamp);
            messageQueue.offer(message);
            return true;
        }
        return false;
    }
    public boolean clean(int timestamp) {
        if (!messageQueue.isEmpty() && timestamp - messageTimestampMap.get(messageQueue.peek()) < TIME_LIMIT) {
            return false;
        }
        messageQueue.clear();
        messageTimestampMap.clear();
        return true;
    }
    public int loggerSize() {
        return messageQueue.size();
    }
}

public class filename {

    public static void main(String[] args) {
        Logger logger = new Logger();
        String message = "", tmstamp = "";
        int timestamp;
        Scanner M = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the message: ");
            message = M.nextLine();
            if (message.equalsIgnoreCase("$finish")) {
                break;
            }
            if (message.equalsIgnoreCase("$size")) {
                System.out.println("Logger Size: " + logger.loggerSize());
                continue;
            }
            while (true) {
                System.out.print("Enter the timestamp: ");
                tmstamp = M.nextLine();
                try {
                    timestamp = Integer.valueOf(tmstamp);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Try again!");
                    continue;
                }
                break;
            }
            if (message.equalsIgnoreCase("$clean")) {
                System.out.println("Status: " + logger.clean(timestamp));
                continue;
            }
            System.out.println("Status: " + logger.shouldPrintMessage(timestamp, message));
        }
        System.out.println("Program was successfully finished!");
    }
}
