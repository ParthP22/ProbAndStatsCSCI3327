public class ConditionalProbability {

    public static double findAGivenB(double PAandB, double PB){
        return PAandB/PB;
    }

    //If true, then independent, else, dependent
    public static boolean independentOrDependence(double PAandB, double PA, double PB){
        return (findAGivenB(PAandB,PB) == PA) || (findAGivenB(PAandB,PA) == PB) || (PAandB == PA * PB);
    }





}
