public class TchebysheffsTheorem {

    public static double findTchebysheffsTheorem(int k){
        return 1 - 1/(Math.pow(k,2));
    }

    public static double findTchebysheffsTheorem(double withinNumber, double standardDeviation){
       return 1 - 1/(Math.pow(findNumberOfStandardDeviation(withinNumber,standardDeviation),2));
    }

    public static double findNumberOfStandardDeviation(double withinNumber, double standardDeviation){
        return withinNumber/standardDeviation;
    }
}
