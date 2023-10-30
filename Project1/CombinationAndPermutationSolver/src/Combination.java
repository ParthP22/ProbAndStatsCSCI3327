import java.math.BigDecimal;

public class Combination {
    public static double findCombination(int n, int r){
        BigDecimal combination = new BigDecimal("1");
        BigDecimal numerator = new BigDecimal(Factorial.factorial(n));
        BigDecimal denominator = new BigDecimal(Factorial.factorial(n - r)).multiply(new BigDecimal(Factorial.factorial(r)));
        combination = numerator.divide(denominator);
        return combination.doubleValue();

    }

    public static void printAnswer(int n, int r){
        System.out.println(n+" choose "+r+" combination: "+Combination.findCombination(n,r));
    }
}
