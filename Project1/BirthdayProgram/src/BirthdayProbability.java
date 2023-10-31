import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author parthpatel0426
 *
 * This <code>BirthdayProbability</code> class is used to calculate the
 * probability of at least two people in the same room having the same birthday,
 * which will be calculated through both trial and mathematical calculation.
 *
 */
public class BirthdayProbability {

    /**
     * This is a constant to represent the highest possible value
     * that can be chosen for a birthday
     */
    private final int daysPerYear = 365;

    /**
     * This HashMap will keep track of the number of occurrences
     * for each possible birthday for a single trial
     */
    private HashMap<Integer,Integer> birthdayOccurrences;

    /**
     * This ArrayList will contain all the different birthdays of
     * each person in the room
     */
    private ArrayList<Integer> birthdays;


    /**
     * This constructor will initialize the <code>birthdayOccurrences</code>
     * HashMap, as well as the <code>birthdays</code> ArrayList
     * to be used later in the functions
     */
    public BirthdayProbability(){
        this.birthdayOccurrences = new HashMap<>();
        this.birthdays = new ArrayList<>();
    }

    /**
     * This function will calculate BigInteger multiplication
     * from a specific number downwards for a specified count
     * (it works in a similar manner a factorial)
     *
     * @param num the number to start at
     * @param count the amount of times to decrement that number and multiply
     * @return the product of all of these numbers
     */
    public BigInteger boundedMultiplication(int num, int count){
        BigInteger product = new BigInteger("1");

        for(int i = num; i > num - count; i--){
            product = product.multiply(new BigInteger(""+i));
        }
        return product;
    }


    /**
     * This function will calculate the probability of at least 2 people in
     * the same room having the same birthday by performing a specified
     * number of trials
     *
     * @param totalPeople the total amount of people in one room
     * @param totalTrials the total amount of trials to be performed
     * @return the probability of at least 2 people having the same birthday in one room
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

    /**
     * This function will keep track of the number of occurrences for
     * each birthday in a single trial by adding it into the
     * <code>birthdayOccurrence</code> HashMap
     */
    private void calculateOccurrences(){
        birthdayOccurrences.clear();
        for(int i = 0; i < birthdays.size(); i++){
            birthdayOccurrences.put(birthdays.get(i), birthdayOccurrences.getOrDefault(birthdays.get(i), 0) + 1);
        }
    }

    /**
     * This function will populate the <code>birthdays</code> ArrayList
     * with various different birthdays for a single trial
     *
     * @param totalPeople the total number of people in one room
     */
    private void fillBirthdays(int totalPeople){
        birthdays.clear();
        for(int i = 0; i < totalPeople; i++){
            birthdays.add((int)(Math.random() * daysPerYear) + 1);
        }
    }

    /**
     * This function will calculate the probability that no two people in the
     * same room have the same birthday (found on page 42 of the textbook).
     * Then, it will calculate the probability that at least two people in the
     * same room have the same birthday via the complement rule.
     *
     * @param totalPeople the total number of people in the same room
     * @return the probability that at least 2 people have the same birthday in one room
     */
    public double findProbabilityByCalculation(int totalPeople){

        BigDecimal na  =  new BigDecimal(this.boundedMultiplication(daysPerYear,totalPeople ));
        BigInteger days = new BigInteger(""+daysPerYear);
        BigDecimal N = new BigDecimal(days.pow(totalPeople ));
        BigDecimal bigProbability = na.divide(N,4, RoundingMode.CEILING);


        double probability = 1 - bigProbability.doubleValue();


        return probability * 100;

    }

    /**
     * This function can be called by the user to calculate the probability of
     * at least two people having the same birthday in the same room by both trial
     * and by calculation.
     *
     * @param totalPeople the total number of people in the same room
     * @param totalTrials the total number of trials to perform
     */
    public void run(int totalPeople, int totalTrials){
        System.out.println("The probability of two people having the same birthday in this room is: " + this.findProbabilityByCalculation(totalPeople) + "%");
        System.out.println("This probability done via calculation is: " + this.findProbabilityByTrial(totalPeople,totalTrials) + "%");
    }



}
