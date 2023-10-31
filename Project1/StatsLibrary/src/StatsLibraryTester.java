import java.util.ArrayList;

/**
 * @author Parth Patel
 * 
 * This <code>StatsLibraryTester</code> class will allow the user to test all
 * the methods of the StatsLibrary project via the <code>testAll</code> method
 *
 */
public class StatsLibraryTester {
    public static void testAll() throws IllegalProbabilityException {

        System.out.println("Creating Set 1: ");
        SetOperations set1 = new SetOperations();
        for(int i = 0; i < 10; i++){
            set1.addElement((int)(Math.random() * 20) + 1);
        }
        System.out.println("Set 1: " + set1 + "\n");

        System.out.println("Creating Set 2: ");
        SetOperations set2 = new SetOperations();
        for(int i = 0; i < 5; i++){
            set2.addElement((int)(Math.random() * 100) + 1);
        }
        System.out.println("Set 2: " + set2 + "\n");

        System.out.println("Creating Universal Set: ");
        SetOperations universal = new SetOperations();
        for(int i = 0; i <= 20; i++){
            universal.addElement(i);
        }
        System.out.println("Universal Set: " + universal + "\n");

        System.out.println("Set 1 union Set 2: " + set1.union(set2));
        System.out.println("Set 1 intersect Set 2: " + set1.intersect(set2));
        System.out.println("Complement of Set 1: " + set1.complement(universal) + "\n");

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
        System.out.println("\nMedian: " + CentralTendency.findMedian(points));
        System.out.println("Mean: " + Math.floor(CentralTendency.findMean(points) * 1000) / 1000);

        System.out.println("Variance: " + Math.floor(Variation.findVariance(points) * 1000) / 1000);
        System.out.println("Standard Deviation: " + Math.floor(Variation.findStandardDeviation(points) * 1000) / 1000 + "\n");

        System.out.println("5! = " + Factorial.factorial(5));

        System.out.println("Combination of 6 choose 4: " + Combinatorics.findCombination(6,4));

        System.out.println("Permutation of 6 choose 4: " + Combinatorics.findPermutation(6,4) + "\n");

        System.out.println("Conditional Probability of A given B, where: probability of A intersect B = 0.5, and probability of B = 0.2");
        System.out.println("Conditional Probability of A given B = " + ConditionalProbability.findAGivenB(0.5,0.2) + "\n");

        System.out.println("Bayes' Theorem of B given A, where: ");
        System.out.println("probability of A given B = " + 0.7);
        System.out.println("probability of A given B complement = " + 0.3);
        System.out.println("probability of B = " + 0.6);
        System.out.println("probability of B complement = " + 0.4);
        System.out.println("Bayes' Theorem of B given A = " + ConditionalProbability.bayesTheorem(0.7,0.6,0.3,0.4) + "\n");

        System.out.println("Determining Independence or Dependence, where: ");
        System.out.println("probability of A and B = " + 0.35);
        System.out.println("probability of A = " + 0.7);
        System.out.println("probability of B = " + 0.5);
        System.out.println("Are A and B independent? : " + ConditionalProbability.independentOrDependence(0.35,0.7,0.5));
        System.out.println("How about if A = 0.8? Are A and B still independent : " + ConditionalProbability.independentOrDependence(0.35,0.8,0.5) + "\n");

        System.out.println("\nALL OF THE VALUES BELOW ARE NOT IN PERCENTAGES\n");


        System.out.println("Find binomial distribution where: ");
        System.out.println("n = " + 4);
        System.out.println("y = " + 2);
        System.out.println("p = " + 0.8);
        System.out.println("q = " + 0.2);
        System.out.println("Probability = " + Distributions.findBinomialDistribution(4,2,0.8,0.2));
        System.out.println("Expected = " + Distributions.findBinomialDistributionExpected(4,0.8));
        System.out.println("Variance = " + Distributions.findBinomialDistributionVariance(4,0.8,0.2));
        System.out.println("Standard Deviation = " + Distributions.findBinomialDistributionStandardDeviation(4,0.8,0.2) + "\n");

        System.out.println("Find geometric distribution where: ");
        System.out.println("y = " + 2);
        System.out.println("p = " + 0.45);
        System.out.println("q = " + 0.55);
        System.out.println("Probability = " + Distributions.findGeometricDistribution(2,0.45,0.55) + "\n");
        System.out.println("Expected = " + Distributions.findGeometricDistributionExpeceted(0.45));
        System.out.println("Variance = " + Distributions.findGeometricDistributionVariance(0.45));
        System.out.println("Standard Deviation = " + Distributions.findGeometricDistributionStandardDeviation(0.45) + "\n");

        System.out.println("Find negative binomial distribution where: ");
        System.out.println("r = " + 3);
        System.out.println("y = " + 4);
        System.out.println("p = " + 0.9);
        System.out.println("q = " + 0.1);
        System.out.println("Probability = " + Distributions.findNegativeBinomialDistribution(3,4,0.9,0.1));
        System.out.println("Expected = " + Distributions.findNegativeBinomialDistributionExpected(3,0.9));
        System.out.println("Variance = " + Distributions.findNegativeBinomialDistributionVariance(3,0.9));
        System.out.println("Standard Deviation = " + Distributions.findNegativeBinomialDistributionStandardDeviation(3,0.9) + "\n");

        System.out.println("Find hypergeometric distribution where: ");
        System.out.println("N = " + 10);
        System.out.println("n = " + 3);
        System.out.println("r = " + 5);
        System.out.println("y = " + 3);
        System.out.println("Probability = " + Distributions.findHypergeometricDistribution(10,3,5,3));
        System.out.println("Expected = " + Distributions.findHypergeometricDistributionExpected(10,3,5));
        System.out.println("Variance = " + Distributions.findHypergeometricDistributionVariance(10,3,5));
        System.out.println("Standard Deviation = " + Distributions.findHypergeometricDistributionStandardDeviation(10,3,5) + "\n");

        System.out.println("Find Poisson distribution where: ");
        System.out.println("lambda = " + 2);
        System.out.println("y = " + 1);
        System.out.println("Probability = " + Distributions.findPoissonDistribution(2,1));
        System.out.println("Expected = " + Distributions.findPoissonDistributionExpected(2));
        System.out.println("Variance = " + Distributions.findPoissonDistributionVariance(2));
        System.out.println("Standard Deviation = " + Distributions.findPoissonDistributionStandardDeviation(2) + "\n");

        System.out.println("Use Tchebysheff's Theorem to find distribution for 2 standard deviations: ");
        System.out.println("Expected = " + 0.5);
        System.out.println("Standard Deviation = " + 0.01);
        System.out.println("Upper bound = " + 0.52);
        System.out.println("Lower bound = " + 0.48);
        System.out.println("Percentage of distribution within 2 standard deviations = " + Math.floor(TchebysheffsTheorem.findTchebysheffsTheorem(0.52,0.5,0.01) * 1000) / 1000);

    }
}
