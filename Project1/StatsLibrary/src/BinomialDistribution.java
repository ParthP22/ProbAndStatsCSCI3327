import java.text.DecimalFormat;

public class BinomialDistribution {

    public static double findBinomialDistribution(int n, int y, double p, double q){
        return Combination.findCombination(n,y) * Math.pow(p,y) * Math.pow(q,(n-y));
    }

}
