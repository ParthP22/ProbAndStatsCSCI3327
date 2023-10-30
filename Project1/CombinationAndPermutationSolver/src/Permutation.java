import java.math.BigDecimal;

public class Permutation {

    public static double findPermutation(int n, int r){
        BigDecimal permutation = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal(Factorial.factorial(n));
        BigDecimal denominator = new BigDecimal(Factorial.factorial(n - r));
        permutation = numerator.divide(denominator);
        return permutation.doubleValue();

    }

    public static void printAnswer(int n, int r){
        System.out.println(n+" choose "+r+" permutation: "+Permutation.findPermutation(n,r));
    }
}
