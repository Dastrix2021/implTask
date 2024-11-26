import java.math.BigInteger;

public class MathUtils {
    /**
     * Method to calculate the factorial of a number.
     * Uses BigInteger to handle very large numbers.
     *
     * @param num The number to calculate the factorial for.
     * @return The factorial of the number as a BigInteger.
     */
    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
