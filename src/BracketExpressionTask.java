import java.math.BigInteger;
import java.util.Scanner;

// Task 1: Calculate the number of valid bracket expressions (Catalan numbers)
public class BracketExpressionTask implements Task {
    private int n;

    @Override
    public void input(Scanner scanner) {
        System.out.println("Enter the number of pairs of brackets: ");
        while (!scanner.hasNext()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.next();
        }
        n = scanner.nextInt();
    }

    @Override
    public void solve() {
        // Calculate the Catalan number using the factorial formula
        BigInteger numerator = MathUtils.factorial(2 * n);
        BigInteger denumerator = MathUtils.factorial(n + 1).multiply(MathUtils.factorial(n));
        BigInteger result = numerator.divide(denumerator);

        // Output the result
        System.out.println("Number of valid bracket expressions for N = " + n + ": " + result);
    }

}
