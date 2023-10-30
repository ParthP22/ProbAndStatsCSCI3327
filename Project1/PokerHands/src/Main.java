import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        HandEvaluator handEvaluator = new HandEvaluator();
        //Note to self: Do not execute another CSV for hand size of 5, because I like the result that I got
        handEvaluator.printProbabilityToCSV(7,100000);


    }

}
