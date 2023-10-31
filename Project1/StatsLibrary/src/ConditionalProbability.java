/**
 * @author parthpatel0426
 *
 * This <code>ConditionalProbability</code> class provides methods to calculate
 * conditional probability, Bayes' Theorem, and a function to determine independence
 * or dependence.
 *
 */
public class ConditionalProbability {

    /**
     * This function calculates the conditional probability of A given B.
     *
     * @param probAandB the probability of the intersection of A and B
     * @param probB the probability of B
     * @return a double value for the probability of A given B
     * @throws IllegalProbabilityException
     */
    public static double findAGivenB(double probAandB, double probB) throws IllegalProbabilityException {
        if(probB <= 0 || probB > 1){
            throw new IllegalProbabilityException("Probability of \'B\' is out of bounds");
        }
        if(probAandB < 0 || probAandB > 1){
            throw new IllegalProbabilityException("Probability of \'A intersect B\' is out of bounds");
        }
        return probAandB/probB;
    }

    /**
     * This function determines whether two events, A and B, are independent,
     * or dependent by testing the 3 conditions.
     *
     * @param probAandB the probability of the intersection of A and B
     * @param probA the probability of A
     * @param probB the probability of B
     * @return true if independent, false if dependent
     * @throws IllegalProbabilityException
     */
    public static boolean independentOrDependence(double probAandB, double probA, double probB) throws IllegalProbabilityException {
        if(probA < 0 || probA > 1){
            throw new IllegalProbabilityException("Probability of \'A\' is out of bounds");
        }
        if(probB < 0 || probB > 1){
            throw new IllegalProbabilityException("Probability of \'B\' is out of bounds");
        }
        if(probAandB < 0 || probAandB > 1){
            throw new IllegalProbabilityException("Probability of \'A intersect B\' is out of bounds");
        }

        return (findAGivenB(probAandB,probA) == probB) || (findAGivenB(probAandB,probA) == probB) || (probAandB == probA * probB);
    }

    /**
     * This function performs Bayes' Theorem, which is a version of conditional probability.
     * It will calculate the probability of B given A.
     *
     * @param probAGivenB the conditional probability of A given B
     * @param probB the probability of B
     * @param probNotB the probability of the complement of B
     * @param probAGivenNotB the conditional probability of A given B complement
     * @return a double value for B given A
     * @throws IllegalProbabilityException
     */
    public static double bayesTheorem(double probAGivenB, double probB, double probNotB, double probAGivenNotB) throws IllegalProbabilityException {
        if(probB <= 0 || probB >= 1){
            throw new IllegalProbabilityException("Probability of \'B\' is out of bounds");
        }
        if(probNotB < 0 || probNotB > 1){
            throw new IllegalProbabilityException("Probability of \'B complement\' is out of bounds");
        }
        if(probAGivenB < 0 || probAGivenB > 1){
            throw new IllegalProbabilityException("Probability of \'A given B\' is out of bounds");
        }
        if(probAGivenNotB < 0 || probAGivenNotB > 1){
            throw new IllegalProbabilityException("Probability of \'A given B complement\' is out of bounds");
        }
        return (probAGivenB) * (probB) / (probAGivenB * probB + probAGivenNotB * probNotB);
    }



}
