import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StatsLibrary {
    //Default constructor
    public StatsLibrary(){

    }
    //Nonempty Constructor
    public StatsLibrary(String input){

    }

    //Mean, Method
    public double findMean(ArrayList<Double> userInputNumbers){
        double sum = 0;

        for(double singleElement : userInputNumbers){
            sum += singleElement;
        }
        //Storing a value for clarity
        double result = sum/userInputNumbers.size();

        return result;
    }
    public double findMedian(ArrayList<Double> userInputNumbers){
        double median = 0;
        if(userInputNumbers.size() % 2 == 1){
             median = userInputNumbers.get(userInputNumbers.size()/2);
        }
        else{
            median = (userInputNumbers.get(userInputNumbers.size()/2 - 1) + userInputNumbers.get(userInputNumbers.size()/2))/2;
        }
        return median;
    }

    public double findMode(ArrayList<Double> userInputNumbers){
        double mode = 0;

        HashMap<Double,Integer> map = new HashMap<>();

        for(double singleElement : userInputNumbers){
            if(map.containsKey(singleElement)){
                map.put(singleElement, map.get(singleElement) + 1);
            }
            else{
                map.put(singleElement, 1);
            }
        }

        //maxCount keeps track of the number of times that the mode occurs
        int maxCount = Integer.MIN_VALUE;
        for(Map.Entry<Double,Integer> keyVal : map.entrySet()){
            if(keyVal.getValue() > maxCount){
                maxCount = keyVal.getValue();
                mode = keyVal.getKey();
            }
        }


        return mode;
    }

    public double findStandardDeviation(ArrayList<Double> userInputNumbers){
        double STD = 0;
        double mean = this.findMean(userInputNumbers);
        double variance = 0;

        for(int i = 0; i < userInputNumbers.size(); i++){
            variance += Math.pow(userInputNumbers.get(i) - mean, 2);
        }
        variance /= userInputNumbers.size() - 1;

        STD = Math.sqrt(variance);

        return STD;
    }

}
