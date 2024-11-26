import java.math.BigInteger;
import java.util.Scanner;

// Task 3: Calculate the sum of digits in a factorial
public class FactorialSumTask implements Task {
    private int number;

    @Override
    public void input(Scanner scanner) {
        System.out.println("Enter a number to calculate its factorial: ");
        while (!scanner.hasNext()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next(); // Clear invalid input
        }
        number = scanner.nextInt();
    }

    @Override
    public void solve() {
        // Calculate factorial using MathUtils
        BigInteger factorial = MathUtils.factorial(number);
        // Calculate the sum of digits
        int sum = 0;
        for (char digit : factorial.toString().toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        // Output the result
        System.out.println("Sum of digits in " + number + "! is: " + sum);
    }
}
