import java.math.BigDecimal;

public class Combinatorics {

    public static double findCombination(int n, int r){
        BigDecimal combination = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal(Factorial.factorial(n));
        BigDecimal denominator = new BigDecimal(Factorial.factorial(n - r)).multiply(new BigDecimal(Factorial.factorial(r)));
        combination = numerator.divide(denominator);
        return combination.doubleValue();

    }

    public static double findPermutation(int n, int r){
        BigDecimal permutation = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal(Factorial.factorial(n));
        BigDecimal denominator = new BigDecimal(Factorial.factorial(n - r));
        permutation = numerator.divide(denominator);
        return permutation.doubleValue();

    }

}
