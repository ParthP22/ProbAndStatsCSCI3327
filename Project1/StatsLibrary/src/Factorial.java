import java.math.BigInteger;

/**
 * @author parthpatel0426
 *
 * This <code>Factorial/code> class provides a function to calculate
 * a factorial using <code>BigInteger</code>
 *
 */
public class Factorial {

    /**
     * This function will calculate the factorial of the given number.
     *
     * @param n an integer value that the factorial will calculate for
     * @return a <code>BigInteger</code> object for the factorial result
     */
    public static BigInteger factorial(int n){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be less than 0");
        }
        BigInteger factorial = new BigInteger("1");
        for(int i = 1; i <= n; i++){
            factorial = factorial.multiply(new BigInteger(i+""));
        }
        return factorial;
    }
}
