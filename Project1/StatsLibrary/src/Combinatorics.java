import java.math.BigDecimal;

/**
 * @author Parth Patel
 *
 * This <code>Combinatorics</code> class provides the combination
 * and permutation functions that are used throughout probability
 * and statistics.
 *
 */
public class Combinatorics {

    /**
     * This function performs the combinatorial operation known as
     * the combination.
     *
     * @param n the total number that we are choosing from
     * @param r the amount that we are picking
     * @return a double value of the combination of n choose r
     */
    public static double findCombination(int n, int r){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be less than 0");
        }
        if(r < 0){
            throw new IllegalArgumentException("\'r\' cannot be less than 0");
        }
        BigDecimal combination = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal(Factorial.factorial(n));
        BigDecimal denominator = new BigDecimal(Factorial.factorial(n - r)).multiply(new BigDecimal(Factorial.factorial(r)));
        combination = numerator.divide(denominator);
        return combination.doubleValue();

    }

    /**
     * This function performs the combinatorial operation known as
     * the permutation.
     *
     * @param n the total number that we are choosing from
     * @param r the amount that we are picking
     * @return a double value of the permutation of n choose r
     */
    public static double findPermutation(int n, int r){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be less than 0");
        }
        if(r < 0){
            throw new IllegalArgumentException("\'r\' cannot be less than 0");
        }
        BigDecimal permutation = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal(Factorial.factorial(n));
        BigDecimal denominator = new BigDecimal(Factorial.factorial(n - r));
        permutation = numerator.divide(denominator);
        return permutation.doubleValue();

    }

}
