/**
 * @author Parth Patel
 *
 * This <code>TchebysheffsTheorem</code> class will calculate
 * the minimum percentage of where the values lie on the distribution for a
 * certain number of standard deviations.
 *
 */
public class TchebysheffsTheorem {

    /**
     * This function will calculate the minimum percentage of where the values
     * lie on the distribution for a specific number of standard deviations.
     *
     * @param k the number of standard deviations
     * @return the minimum percentage of where the distributions lie
     */
    public static double findTchebysheffsTheorem(int k){
        return 1 - 1/(Math.pow(k,2));
    }

    /**
     * This function will calculate the minimum percentage of where the values
     * lie on the distribution for a specific number of standard deviations.
     *
     * @param upperBound the value of the upper bound on the distribution
     * @param expected the expected value, or mean, of the distribution
     * @param standardDeviation the double value for standard deviation
     * @return the minimum percentage of where the distributions lie
     */
    public static double findTchebysheffsTheorem(double upperBound, double expected, double standardDeviation){
       return 1 - 1/(Math.pow(findNumberOfStandardDeviations(upperBound,expected,standardDeviation),2));
    }

    /**
     * This function will calculate the number of standard deviations.
     *
     * @param upperBound the value of the upper bound on the distribution
     * @param expected the expected value, or mean, of the distribution
     * @param standardDeviation the double value for the standard deviation
     * @return a double value for the number of standard deviations
     */
    public static double findNumberOfStandardDeviations(double upperBound, double expected, double standardDeviation){
        return (upperBound - expected)/standardDeviation;
    }
}
