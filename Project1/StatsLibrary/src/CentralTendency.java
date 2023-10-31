import java.util.*;

/**
 * @author Parth Patel
 *
 * This <code>CentralTendency</code> class provides functions to
 * calculate the mean, median, and mode of a given list of data points.
 *
 */
public class CentralTendency{

    /**
     * Calculates the average, or mean, based on the data points
     *
     * @param points an <code>ArrayList</code> of double values for the data points
     * @return a double value for the mean
     */
    public static double findMean(List<Double> points){
        double sum = 0;
        for(double point : points){
            sum += point;
        }
        return sum / points.size();
    }


    /**
     * Calculates the mode(s) of the data points (there can be multiple values
     * that have the same number of highest occurrences).
     *
     * @param points an <code>ArrayList</code> of double values for the data points
     * @return an array of doubles consisting of all the modes among these data points
     */
    public static double[] findMode(List<Double> points){
        HashMap<Double,Integer> numOfOccurrences = new HashMap<>();
        for(Double element : points){
            numOfOccurrences.put(element, numOfOccurrences.getOrDefault(element,0) + 1);
        }

        int maxOccurrences = -1;
        PriorityQueue<Map.Entry<Double,Integer>> minHeap = new PriorityQueue<>( (a,b) -> a.getValue() - b.getValue() );

        for(Map.Entry<Double,Integer> entry : numOfOccurrences.entrySet()){
            if(maxOccurrences < entry.getValue()){
                maxOccurrences = entry.getValue();
            }
            minHeap.offer(entry);
        }

        while(minHeap.peek().getValue() != maxOccurrences){
            minHeap.poll();
        }

        int totalModes = minHeap.size();
        double[] modes = new double[totalModes];
        int index = 0;

        while(!minHeap.isEmpty()){
            modes[index] = minHeap.poll().getKey();
            index++;
        }

        return modes;
    }

    /**
     * Calculates the median, or middle, of these data points
     *
     * @param points an <code>ArrayList</code> of double values for the data points
     * @return a double value for the median
     */
    public static double findMedian(List<Double> points){
        if(points.size() == 0){
            return Double.MIN_VALUE;
        }
        if(points.size() == 1){
            return points.get(0);
        }

        Collections.sort(points);
        printPoints(points);
        int size = points.size();
        if(size % 2 == 1){
            return points.get(size/2);
        }
        else{
            return (points.get(size/2) + points.get(size/2 - 1))/2;
        }
    }

    /**
     * This function will print the data points to the console.
     *
     * @param points an <code>ArrayList</code> of double values for the data points
     */
    public static void printPoints(List<Double> points){
        for(Double point : points){
            System.out.print(point + ", ");
        }
        System.out.println("\n");
    }





}
