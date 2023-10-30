public class ConditionalProbability {

    public static double findAGivenB(double probAandB, double probB) throws IllegalProbabilityException {
        if(probB <= 0 || probB > 1){
            throw new IllegalProbabilityException("Probability of \'B\' is out of bounds");
        }
        if(probAandB < 0 || probAandB > 1){
            throw new IllegalProbabilityException("Probability of \'A intersect B\' is out of bounds");
        }
        return probAandB/probB;
    }

    //If true, then independent, else, dependent
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
