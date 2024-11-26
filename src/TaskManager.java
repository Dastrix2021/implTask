import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// TaskManager to manage and execute tasks
public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    // Add a task to the manager
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Execute all tasks
    public void executeTasks() {
        Scanner scanner = new Scanner(System.in);
        for (Task task : tasks) {
            System.out.println("Processing task...");
            task.input(scanner);
            task.solve();
        }
        scanner.close();
    }
}
