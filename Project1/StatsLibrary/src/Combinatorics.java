import java.math.BigDecimal;

public class Combinatorics {

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
