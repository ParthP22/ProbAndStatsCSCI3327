import java.util.ArrayList;

/**
 * @author Parth Patel
 * 
 * 
 *
 */
public class StatsLibraryTester {
    public static void testAll() throws IllegalProbabilityException {

        System.out.println("Creating Set 1: ");
        SetOperations set1 = new SetOperations();
        for(int i = 0; i < 10; i++){
            set1.addElement((int)(Math.random() * 20) + 1);
        }
        System.out.println("Set 1: " + set1);

        System.out.println("Creating Set 2: ");
        SetOperations set2 = new SetOperations();
        for(int i = 0; i < 5; i++){
            set2.addElement((int)(Math.random() * 100) + 1);
        }
        System.out.println("Set 2: " + set2);

        System.out.println("Creating Universal Set: ");
        SetOperations universal = new SetOperations();
        for(int i = 0; i <= 20; i++){
            universal.addElement(i);
        }
        System.out.println("Universal Set: " + universal);

        System.out.println("Set 1 union Set 2: " + set1.union(set2));
        System.out.println("Set 1 intersect Set 2: " + set1.intersect(set2));
        System.out.println("Complement of Set 1: " + set1.complement(universal));

        System.out.println("Creating data points: ");
        ArrayList<Double> points = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            double point = (double)((int)((Math.random()*10) + 1));
            points.add(point);
        }
        System.out.println("Data points: " + points);


        double[] modes = CentralTendency.findMode(points);
        System.out.print("Modes: ");
        for(double mode : modes){
            System.out.print(mode + ", ");
        }
        System.out.println();

        System.out.println("Median: " + CentralTendency.findMedian(points));
        System.out.println("Mean: " + Math.floor(CentralTendency.findMean(points) * 1000) / 1000);

        System.out.println("Variance: " + Math.floor(Variation.findVariance(points) * 1000) / 1000);
        System.out.println("Standard Deviation: " + Math.floor(Variation.findStandardDeviation(points) * 1000) / 1000);

        System.out.println("5! = " + Factorial.factorial(5));

        System.out.println("Combination of 6 choose 4: " + Combinatorics.findCombination(6,4));

        System.out.println("Permutation of 6 choose 4: " + Combinatorics.findPermutation(6,4));

        System.out.println("Conditional Probability of A given B, where: probability of A intersect B = 0.5, and probability of B = 0.2" + ConditionalProbability.findAGivenB(0.5,0.2));

        


    }
}
