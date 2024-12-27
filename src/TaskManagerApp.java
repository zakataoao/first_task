import java.util.Scanner;

public class TaskManagerApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();
    private static final AlarmManager alarmManager = new AlarmManager();

    public static void run() {
        System.out.println("Добро пожаловать в Task Manager и Будильник!");
        String command;

        do {
            showMenu();
            command = scanner.nextLine().trim();

            switch (command) {
                case "add-task" -> taskManager.addTask(scanner);
                case "view-tasks" -> taskManager.viewTasks();
                case "complete-task" -> taskManager.completeTask(scanner);
                case "remove-task" -> taskManager.removeTask(scanner);
                case "add-alarm" -> alarmManager.addAlarm(scanner);
                case "view-alarms" -> alarmManager.viewAlarms();
                case "exit" -> System.out.println("Выход из программы.");
                default -> System.out.println("Неизвестная команда, попробуйте снова.");
            }
        } while (!command.equals("exit"));
    }

    private static void showMenu() {
        System.out.println("\nДоступные команды:");
        System.out.println("1. add-task - Добавить задачу");
        System.out.println("2. view-tasks - Просмотр задач");
        System.out.println("3. complete-task - Завершить задачу");
        System.out.println("4. remove-task - Удалить задачу");
        System.out.println("5. add-alarm - Добавить будильник");
        System.out.println("6. view-alarms - Просмотр будильников");
        System.out.println("7. exit - Выйти");
        System.out.print("Введите команду: ");
    }
}
