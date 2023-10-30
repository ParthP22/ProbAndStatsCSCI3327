public class Distributions {

    public static double findBinomialDistribution(int n, int y, double p, double q){
        return Combinatorics.findCombination(n,y) * Math.pow(p,y) * Math.pow(q,(n-y));
    }

    public static double findBinomialDistributionExpected(int n, double p){
        return (double)n * p;
    }

    public static double findBinomialDistributionVariance(int n, double p, double q){
        return (double)n * p * q;
    }

    public static double findBinomialDistributionStandardDeviation(int n, double p, double q){
        return Math.sqrt(findBinomialDistributionVariance(n, p, q));
    }

    public static double findGeometricDistribution(int y, double p, double q){
        return (Math.pow(q,(y-1)) * p);

    }

    public static double findGeometricDistribution(int y, double p){

        return (Math.pow(1 - p,(y-1)) * p);
    }

    public static double findGeometricDistributionExpeceted(double p){
        return (double)1/p;
    }

    public static double findGeometricDistributionVariance(double p){
        return (double)(1 - p)/Math.pow(p,2);
    }

    public static double findGeometricDistributionStandardDeviation(double p){
        return Math.sqrt(findGeometricDistributionVariance(p));
    }



    public static double findHypergeometricDistribution(int N, int n, int r, int y){
        return (Combinatorics.findCombination(r , y) * Combinatorics.findCombination((N-r) , (n-y)) / Combinatorics.findCombination(N , n));
    }

    public static double findHypergeometricDistributionExpected(int N, int n, int r){
        return (double)n * r / N;
    }

    public static double findHypergeometricDistributionVariance(int N, int n, int r){
        return (double)n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1));
    }

    public static double findHypergeometricDistributionStandardDeviation(int N, int n, int r){
        return Math.sqrt(findHypergeometricDistributionVariance(N, n, r));
    }

    public static double findNegativeBinomialDistribution(int r, int y, double p, double q){
        return (Combinatorics.findCombination(y - 1, r - 1) * Math.pow(p,r) * Math.pow(q, y - r));
    }

    public static double findNegativeBinomialDistributionExpected(int r, double p){
        return (double)r / p;
    }

    public static double findNegativeBinomialDistributionVariance(int r, double p){
        return r * (1 - p) / Math.pow(p, 2);
    }

    public static double findNegativeBinomialDistributionStandardDeviation(int r, double p){
        return Math.sqrt(findNegativeBinomialDistributionVariance(r, p));
    }

    public static double findPoissonDistribution(double lambda, int y){
        return Math.pow(lambda,y) * Math.exp(-lambda) / Factorial.factorial(y).doubleValue();
    }



}
