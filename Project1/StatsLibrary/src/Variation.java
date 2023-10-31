import java.util.ArrayList;

/**
 * @author Parth Patel
 * 
 * This <code>Variance</code> class provides the functions to calculate
 * variance and standard deviation, either based on a set of data points,
 * or by using any given values.
 *
 */
public class Variation {

    /**
     * @param points is an <code>ArrayList</code> of double values that contains all of the data points
     * @return a double value for the variance of the data points
     */
    public static double findVariance(ArrayList<Double> points){
        double mean = CentralTendency.findMean(points);
        double summation = 0;
        for(double point : points){
            summation += Math.pow((point - mean),2);
        }
        return summation / (points.size() - 1);
    }


    /**
     * @param points is an <code>ArrayList</code> of double values that contains all the data points
     * @return a double value for the standard deviation of the data points
     */
    public static double findStandardDeviation(ArrayList<Double> points){
        return Math.sqrt(findVariance(points));
    }

    /**
     * @param variance is a double value of the variance
     * @return a double value for the standard deviation
     */
    public static double findStandardDeviation(double variance){
        return Math.sqrt(variance);
    }


}
