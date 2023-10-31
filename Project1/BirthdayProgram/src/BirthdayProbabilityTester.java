/**
 * @author Parth Patel
 *
 * This <code>BirthdayProbabilityTester</code> will be executing the <code>run</code>
 * function in order to display the probability of at least two people in the same room
 * having the same birthday by both trial and by calculation.
 */
public class BirthdayProbabilityTester {
    public static void main(String[] args){
        BirthdayProbability bp = new BirthdayProbability();
        bp.run(25,10000);
    }
}
