import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(Scanner scanner) {
        System.out.print("Введите описание задачи: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Задача добавлена.");
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
        } else {
            System.out.println("Список задач:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.printf("%d. %s [%s]\n", i + 1, tasks.get(i).getDescription(), tasks.get(i).isCompleted() ? "Завершена" : "В процессе");
            }
        }
    }

    public void completeTask(Scanner scanner) {
        viewTasks();
        System.out.print("Введите номер задачи для завершения: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setCompleted(true);
            System.out.println("Задача завершена.");
        } else {
            System.out.println("Неверный номер задачи.");
        }
    }

    public void removeTask(Scanner scanner) {
        viewTasks();
        System.out.print("Введите номер задачи для удаления: ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Задача удалена.");
        } else {
            System.out.println("Неверный номер задачи.");
        }
    }
}
