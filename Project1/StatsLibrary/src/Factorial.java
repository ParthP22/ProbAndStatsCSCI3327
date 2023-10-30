import java.math.BigInteger;

public class Factorial {
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
