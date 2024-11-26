import java.util.Scanner;

// Base interface for all tasks
public interface Task {
    /**
     * Method to take input for the task.
     *
     * @param scanner The Scanner object to read user input.
     */
    void input(Scanner scanner);

    /**
     * Method to solve the task.
     */
    void solve();
}
