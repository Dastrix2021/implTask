import java.util.Scanner;

// Main class to run the program
public class TaskSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of test cases
        System.out.print("Enter the number of test cases: ");
        int testCases = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Handle each test case
        for (int t = 0; t < testCases; t++) {
            System.out.println("Processing Test Case " + (t + 1) + ":");
            ShortestPathTask pathTask = new ShortestPathTask();
            pathTask.input(scanner); // Take input for this test case
            pathTask.solve();        // Solve the shortest path problem immediately
        }

        // Add other tasks
        TaskManager manager = new TaskManager();
        manager.addTask(new FactorialSumTask());
        manager.addTask(new BracketExpressionTask());
        System.out.println("Executing additional tasks...");
        manager.executeTasks(); // Execute additional tasks
    }
}
