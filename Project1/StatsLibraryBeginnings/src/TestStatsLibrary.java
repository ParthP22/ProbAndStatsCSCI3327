import java.util.ArrayList;

public class TestStatsLibrary {
    public static void main(String[] args){
        StatsLibrary test = new StatsLibrary("Hello World");

        ArrayList<Double> testNumbers = new ArrayList<>();
        testNumbers.add(1.0);
        testNumbers.add(2.0);
        testNumbers.add(3.0);
        testNumbers.add(4.0);
        testNumbers.add(5.0);
        testNumbers.add(6.0);
        testNumbers.add(7.0);
        testNumbers.add(8.0);
        testNumbers.add(9.0);
        testNumbers.add(10.0);

        double testerResult = test.findMean(testNumbers);
        System.out.println("This is the average of testNumbers: " + testerResult);
        System.out.println("This is the median of testNumbers: " + test.findMedian(testNumbers));
        System.out.println("This is the mode of testNumbers: " + test.findMode(testNumbers));
        System.out.println("This is the standard deviation of testNumbers: " + test.findStandardDeviation(testNumbers));



    }
}
