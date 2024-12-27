import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmManager {
    private final List<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Scanner scanner) {
        System.out.print("Введите время будильника (в формате yyyy-MM-dd HH:mm): ");
        String timeInput = scanner.nextLine();

        try {
            LocalDateTime alarmTime = LocalDateTime.parse(timeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            alarms.add(new Alarm(alarmTime));
            System.out.println("Будильник добавлен.");

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Будильник! Время: " + alarmTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                }
            }, java.sql.Timestamp.valueOf(alarmTime));
        } catch (Exception e) {
            System.out.println("Неверный формат даты и времени. Попробуйте снова.");
        }
    }

    public void viewAlarms() {
        if (alarms.isEmpty()) {
            System.out.println("Список будильников пуст.");
        } else {
            System.out.println("Список будильников:");
            for (Alarm alarm : alarms) {
                System.out.println(alarm.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            }
        }
    }
}
