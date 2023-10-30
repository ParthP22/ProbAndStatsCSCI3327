public class Distributions {

    public static double findBinomialDistribution(int n, int y, double p, double q) throws IllegalProbabilityException {
        if(y < 0 || y > n){
            throw new IllegalArgumentException("\'y\' is out of bounds");
        }
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        if(q < 0 || q > 1){
            throw new IllegalProbabilityException("\'q\' is out of bounds");
        }
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return Combinatorics.findCombination(n,y) * Math.pow(p,y) * Math.pow(q,(n-y));
    }

    public static double findBinomialDistributionExpected(int n, double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * p;
    }

    public static double findBinomialDistributionVariance(int n, double p, double q) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        if(q < 0 || q > 1){
            throw new IllegalProbabilityException("\'q\' is out of bounds");
        }
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * p * q;
    }

    public static double findBinomialDistributionStandardDeviation(int n, double p, double q) throws IllegalProbabilityException {
        return Math.sqrt(findBinomialDistributionVariance(n, p, q));
    }

    public static double findGeometricDistribution(int y, double p, double q) throws IllegalProbabilityException {
        if(y < 0){
            throw new IllegalArgumentException("\'y\' is out of bounds");
        }
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        if(q < 0 || q > 1){
            throw new IllegalProbabilityException("\'q\' is out of bounds");
        }
        return (Math.pow(q,(y-1)) * p);

    }

    public static double findGeometricDistribution(int y, double p) throws IllegalProbabilityException {
        if(y < 0){
            throw new IllegalArgumentException("\'y\' is out of bounds");
        }
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (Math.pow(1 - p,(y-1)) * p);
    }

    public static double findGeometricDistributionExpeceted(double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (double)1/p;
    }

    public static double findGeometricDistributionVariance(double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (double)(1 - p)/Math.pow(p,2);
    }

    public static double findGeometricDistributionStandardDeviation(double p) throws IllegalProbabilityException {
        return Math.sqrt(findGeometricDistributionVariance(p));
    }



    public static double findHypergeometricDistribution(int N, int n, int r, int y){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        if(y > r){
            throw new IllegalArgumentException("\'y\' cannot be greater than \'r\'");
        }
        if((n-y) > (N-r)){
            throw new IllegalArgumentException("\'(n-y)\' cannot be greater than \'(N-r)\'");
        }
        return (Combinatorics.findCombination(r , y) * Combinatorics.findCombination((N-r) , (n-y)) / Combinatorics.findCombination(N , n));
    }

    public static double findHypergeometricDistributionExpected(int N, int n, int r){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * r / N;
    }

    public static double findHypergeometricDistributionVariance(int N, int n, int r){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1));
    }

    public static double findHypergeometricDistributionStandardDeviation(int N, int n, int r){
        return Math.sqrt(findHypergeometricDistributionVariance(N, n, r));
    }

    public static double findNegativeBinomialDistribution(int r, int y, double p, double q) throws IllegalProbabilityException {
        if(y > r){
            throw new IllegalArgumentException("\'y\' cannot be greater than \'r\'");
        }
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        if(q < 0 || q > 1){
            throw new IllegalProbabilityException("\'q\' is out of bounds");
        }
        return (Combinatorics.findCombination(y - 1, r - 1) * Math.pow(p,r) * Math.pow(q, y - r));
    }

    public static double findNegativeBinomialDistributionExpected(int r, double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1) {
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (double)r / p;
    }

    public static double findNegativeBinomialDistributionVariance(int r, double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }

        return r * (1 - p) / Math.pow(p, 2);
    }

    public static double findNegativeBinomialDistributionStandardDeviation(int r, double p) throws IllegalProbabilityException {
        return Math.sqrt(findNegativeBinomialDistributionVariance(r, p));
    }

    public static double findPoissonDistribution(double lambda, int y){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        if(y < 0){
            throw new IllegalArgumentException("\'y\' cannot be less than zero");
        }
        return Math.pow(lambda,y) * Math.exp(-lambda) / Factorial.factorial(y).doubleValue();
    }

    public static double findPoissonDistributionExpected(double lambda){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        return lambda;
    }

    public static double findPoissonDistributionVariance(double lambda){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        return lambda;
    }

    public static double findPoissonDistributionStandardDeviation(double lambda){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        return Math.sqrt(lambda);
    }

}
