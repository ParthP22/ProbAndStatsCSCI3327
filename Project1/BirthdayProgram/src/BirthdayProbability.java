import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BirthdayProbability {

    private final int daysPerYear = 365;
    private HashMap<Integer,Integer> birthdayOccurrences;

    private ArrayList<Integer> birthdays;

    public BirthdayProbability(){
        this.birthdayOccurrences = new HashMap<>();
        this.birthdays = new ArrayList<>();
    }



    public BigInteger boundedMultiplication(int num, int count){
        BigInteger product = new BigInteger("1");

        for(int i = num; i > num - count; i--){
            product = product.multiply(new BigInteger(""+i));
        }
        return product;
    }

    /*
    public double findProbability(int totalPeople){

        ArrayList<Birthday> birthdays = Birthday.generateRandomBirthday(totalPeople);
        HashMap<Birthday,Integer> birthdayOccurrences = Birthday.birthdayOccurrences(birthdays);
        int totalSharedBirthdays = Birthday.numberOfSharedBirthdays(birthdayOccurrences);

        //return ((double)totalSharedBirthdays)/((double)birthdays.size());
        return totalSharedBirthdays;
    }
    */
    public double findProbabilityByTrial(int totalPeople, int totalTrials){
        int totalSuccesses = 0;
        for(int i = 0; i < totalTrials; i++){
            this.fillBirthdays(totalPeople);
            this.calculateOccurrences();
            for(Map.Entry<Integer,Integer> entry : birthdayOccurrences.entrySet()){
                if(entry.getValue() > 1){
                    totalSuccesses++;
                    break;
                }
            }
        }
        return (double)totalSuccesses/(double)totalTrials * 100;
    }

    private void calculateOccurrences(){
        birthdayOccurrences.clear();
        for(int i = 0; i < birthdays.size(); i++){
            birthdayOccurrences.put(birthdays.get(i), birthdayOccurrences.getOrDefault(birthdays.get(i), 0) + 1);
        }
    }

    private void fillBirthdays(int totalPeople){
        birthdays.clear();
        for(int i = 0; i < totalPeople; i++){
            birthdays.add((int)(Math.random() * daysPerYear) + 1);
        }
    }


    public double findProbabilityByCalculation(int totalPeople){

        BigDecimal na  =  new BigDecimal(this.boundedMultiplication(daysPerYear,totalPeople ));
        BigInteger days = new BigInteger(""+daysPerYear);
        BigDecimal N = new BigDecimal(days.pow(totalPeople ));
        BigDecimal bigProbability = na.divide(N,4, RoundingMode.CEILING);

        /*
        BigInteger na  =  boundedMultiplication(daysPerYear,totalPeople);
        BigInteger days = new BigInteger(""+daysPerYear);
        BigInteger N = days.pow(totalPeople);
        BigInteger bigProbability = na.divide(N);
        //BigDecimal prob = new BigDecimal();
        */

        double probability = 1 - bigProbability.doubleValue();


        return probability * 100;

    }



}
