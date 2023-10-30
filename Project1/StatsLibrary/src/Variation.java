import java.util.ArrayList;

public class Variation {

    public static double findVariance(ArrayList<Double> points){
        double mean = CentralTendency.findMean(points);
        double summation = 0;
        for(double point : points){
            summation += Math.pow((point - mean),2);
        }
        return summation / (points.size() - 1);
    }

    public static double findStandardDeviation(ArrayList<Double> points){
        return Math.sqrt(findVariance(points));
    }

    public static double findStandardDeviation(double variance){
        return Math.sqrt(variance);
    }

}
