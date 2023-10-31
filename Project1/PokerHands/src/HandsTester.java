import java.io.IOException;

/**
 * @author Parth Patel
 *
 * This <code>HandsTester</code> program will run code to print the probabilities of
 * the 9 Poker hand types to the console for hand sizes of 5 and 7,
 * as well as print these probabilities to their respective .csv files
 *
 */
public class HandsTester {
    public static void main(String[] args) throws IOException {
        HandEvaluator handEvaluator = new HandEvaluator();
        handEvaluator.run();
    }
}
