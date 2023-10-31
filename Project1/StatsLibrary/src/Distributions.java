/**
 * @author Parth Patel
 *
 * This <code>Distribution</code> class is used to calculate the probabilities,
 * expected, variance, and standard deviation of the following probability
 * distributions: binomial, geometric, negative binomial, hypergeometric,
 * and Poisson.
 *
 */
public class Distributions {

    /**
     * This function will calculate the probability of an event that can either succeed or
     * fail, and run that event a certain amount times
     *
     * @param n the number of identical trials that are carried out
     * @param y the random variable
     * @param p the probability of success
     * @param q the probability of failure
     * @return double value for the probability of this binomial distribution
     * @throws IllegalProbabilityException
     */
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

    /**
     * This function calculates the expected value, or mean, of this binomial
     * distribution.
     *
     * @param n the number of identical trials that are carried out
     * @param p the probability of success
     * @return double value for the expected of this binomial distribution
     * @throws IllegalProbabilityException
     */
    public static double findBinomialDistributionExpected(int n, double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * p;
    }

    /**
     * This function calculates the variance value of this binomial
     * distribution.
     *
     * @param n the number of identical trials that are carried out
     * @param p the probability of success
     * @param q the probability of failure
     * @return double value for the variance of this binomial distribution
     * @throws IllegalProbabilityException
     */
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

    /**
     * This function calculates the standard deviation of this binomial
     * distribution.
     *
     * @param n the number of identical trials that are carried out
     * @param p the probability of success
     * @param q the probability of failure
     * @return double value for the standard deviation of this binomial distribution
     * @throws IllegalProbabilityException
     */
    public static double findBinomialDistributionStandardDeviation(int n, double p, double q) throws IllegalProbabilityException {
        return Math.sqrt(findBinomialDistributionVariance(n, p, q));
    }

    /**
     * This function will calculate the probability of the 1st success based
     * on some number of trials
     *
     * @param y the random variable
     * @param p the probability of success
     * @param q the probability of failure
     * @return double value for the probability of geometric distribution
     * @throws IllegalProbabilityException
     */
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

    /**
     * This function will calculate the probability of the 1st success based
     * on some number of trials
     *
     * @param y the random variable
     * @param p the probability of success
     * @return double value for the probability of this geometric distribution
     * @throws IllegalProbabilityException
     */
    public static double findGeometricDistribution(int y, double p) throws IllegalProbabilityException {
        if(y < 0){
            throw new IllegalArgumentException("\'y\' is out of bounds");
        }
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (Math.pow(1 - p,(y-1)) * p);
    }

    /**
     * This function calculates the expected value, or mean, of this geometric
     * distribution.
     *
     * @param p the probability of success
     * @return double value for the expected of this geometric distribution
     * @throws IllegalProbabilityException
     */
    public static double findGeometricDistributionExpeceted(double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (double)1/p;
    }

    /**
     * This function calculates the variance value of this geometric
     * distribution.
     *
     * @param p the probability of success
     * @return double value for the variance of this geometric distribution
     * @throws IllegalProbabilityException
     */
    public static double findGeometricDistributionVariance(double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (double)(1 - p)/Math.pow(p,2);
    }

    /**
     * This function calculates the standard deviation of this geometric
     * distribution.
     *
     * @param p the probability of success
     * @return double value for the standard deviation of this geometric distribution
     * @throws IllegalProbabilityException
     */
    public static double findGeometricDistributionStandardDeviation(double p) throws IllegalProbabilityException {
        return Math.sqrt(findGeometricDistributionVariance(p));
    }



    /**
     * This function calculates the probability of obtaining y-number of items when
     * selecting an n-number of items from the population without replacement, while
     * assuming that all selections are equally likely.
     *
     * @param N the total number of both Type 1 and Type 2 items
     * @param n the total number of both Type 1 and Type 2 items that are being selected together
     * @param r the total number of Type 1 items
     * @param y the random variable (the number of Type 1 items that you want to obtain)
     * @return double value for the probability of this hypergeometric distribution
     */
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

    /**
     * This function calculates the expected value, or mean, of this hypergeometric
     * distribution.
     *
     * @param N the total number of both Type 1 and Type 2 items
     * @param n the total number of both Type 1 and Type 2 items that are being selected together
     * @param r the total number of Type 1 items
     * @return double value for the expected of this hypergeometric distribution
     */
    public static double findHypergeometricDistributionExpected(int N, int n, int r){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * r / N;
    }

    /**
     * This function calculates the variance value of this hypergeometric
     * distribution.
     *
     * @param N the total number of both Type 1 and Type 2 items
     * @param n the total number of both Type 1 and Type 2 items that are being selected together
     * @param r the total number of Type 1 items
     * @return double value for the variance of this hypergeometric distribution
     */
    public static double findHypergeometricDistributionVariance(int N, int n, int r){
        if(n < 0){
            throw new IllegalArgumentException("\'n\' cannot be negative");
        }
        return (double)n * (r / N) * ((N - r) / N) * ((N - n) / (N - 1));
    }

    /**
     * This function calculates the standard deviation of this hypergeometric
     * distribution.
     *
     * @param N the total number of both Type 1 and Type 2 items
     * @param n the total number of both Type 1 and Type 2 items that are being selected together
     * @param r the total number of Type 1 items
     * @return double value for the standard deviation of this hypergeometric distribution
     */
    public static double findHypergeometricDistributionStandardDeviation(int N, int n, int r){
        return Math.sqrt(findHypergeometricDistributionVariance(N, n, r));
    }

    /**
     * This function is used to calculate to find the probability of the r-th success
     * based on some number of trials.
     *
     * @param r the number of the success
     * @param y the random variable
     * @param p the probability of success
     * @param q the probability of failure
     * @return double value for the probability of this negative binomial distribution
     * @throws IllegalProbabilityException
     */
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

    /**
     * This function calculates the expected value, or mean, of this negative
     * binomial distribution.
     *
     * @param r the number of the success
     * @param p the probability of success
     * @return double value for the expected of this negative binomial distribution
     * @throws IllegalProbabilityException
     */
    public static double findNegativeBinomialDistributionExpected(int r, double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1) {
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }
        return (double)r / p;
    }

    /**
     * This function calculates the variance value of this negative
     * binomial distribution.
     *
     * @param r the number of the success
     * @param p the probability of success
     * @return double value for the variance of this negative binomial distribution
     * @throws IllegalProbabilityException
     */
    public static double findNegativeBinomialDistributionVariance(int r, double p) throws IllegalProbabilityException {
        if(p < 0 || p > 1){
            throw new IllegalProbabilityException("\'p\' is out of bounds");
        }

        return r * (1 - p) / Math.pow(p, 2);
    }

    /**
     * This function calculates the standard deviation of this negative binomial
     * distribution.
     *
     * @param r the number of the success
     * @param p the probability of success
     * @return double value for the standard deviation of this negative binomial distribution
     * @throws IllegalProbabilityException
     */
    public static double findNegativeBinomialDistributionStandardDeviation(int r, double p) throws IllegalProbabilityException {
        return Math.sqrt(findNegativeBinomialDistributionVariance(r, p));
    }

    /**
     * to acquire the probability of the number of occurrences on a per-unit basis
     * (such as per-unit-time, or per-unit-area)
     *
     * @param lambda the given average value or average rate
     * @param y the random variable
     * @return double value for the probability of this Poisson distribution
     */
    public static double findPoissonDistribution(double lambda, int y){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        if(y < 0){
            throw new IllegalArgumentException("\'y\' cannot be less than zero");
        }
        return Math.pow(lambda,y) * Math.exp(-lambda) / Factorial.factorial(y).doubleValue();
    }

    /**
     * This function calculates the expected value, or mean, of this Poisson
     * distribution.
     *
     * @param lambda the given average value or average rate
     * @return double value for the expected of this Poisson distribution
     */
    public static double findPoissonDistributionExpected(double lambda){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        return lambda;
    }

    /**
     * This function calculates the variance value of this Poisson
     * distribution.
     *
     * @param lambda the given average value or average rate
     * @return double value for the variance of this Poisson distribution
     */
    public static double findPoissonDistributionVariance(double lambda){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        return lambda;
    }

    /**
     * This function calculates the standard deviation of this Poisson
     * distribution.
     *
     * @param lambda the given average value or average rate
     * @return double value for the standard deviation of this Poisson distribution
     */
    public static double findPoissonDistributionStandardDeviation(double lambda){
        if(lambda <= 0){
            throw new IllegalArgumentException("\'lambda\' cannot be less than or equal to zero");
        }
        return Math.sqrt(lambda);
    }

}
