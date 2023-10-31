import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @author parthpatel0426
 *
 * This program will calculate the probabilities (as percentages) of the following
 * poker hands: pair, 3 of a kind, 4 of a kind, straight, flush, full house, straight
 * flush, and royal flush.
 *
 * These probabilities will be calculated for hand sizes of 5 and 7, and will be printed
 * to their respective .csv files when executing the <code>run</code> method
 *
 */
public class HandEvaluator {

    /**
     * Stores the cards that are currently in the player's hand
     */
    private ArrayList<Card> hand;
    /**
     * Stores the cards that are currently in the deck
     */
    private Stack<Card> deck;



    /**
     * This HashMap will convert the String values that are set for each card
     * to a number, so that the values of cards can be compared
     */
    private HashMap<String,Integer> valueToNumerical;

    /**
     * This HashMap will count of the number of occurrences of each card
     * per hand in each trial
     */
    private HashMap<String,Integer> handValuesOccurrences;

    /**
     * This HashMap will count the number of total occurrences of each hand
     * throughout all the trials
     */
    private HashMap<String,Double> countHands;

    /**
     * This HashMap will store the percentage values that were calculated
     * for each hand
     */
    private HashMap<String,Double> handProbabilitiesPercentage;

    /**
     * This Stack is used to help shuffle the cards, resembling the left hand
     * of the dealer when shuffling
     */
    private Stack<Card> dealersLeftHand;
    /**
     * This Stack is used to help shuffle the cards, resembling the right hand
     * of the dealer when shuffling
     */
    private Stack<Card> dealersRightHand;

    /**
     * This is the constructor, which initializes all the fields and data structures
     * used within this class, and also shuffles the deck 100 times, to ensure
     * that it randomizes the cards as much as possible.
     */
    public HandEvaluator(){
        this.hand = new ArrayList<>();
        this.deck = new Stack<>();
        this.generateDeck();

        dealersRightHand = new Stack<>();
        dealersLeftHand = new Stack<>();

        for(int i = 0; i < 100; i++){
            this.shuffleDeck();
        }


        this.valueToNumerical = new HashMap<>();

        //An Ace will be assumed to equate to a 1.
        this.valueToNumerical.put("A",1);
        for(int i = 2; i <= 10; i++){
            this.valueToNumerical.put(""+i,i);
        }
        this.valueToNumerical.put("J",11);
        this.valueToNumerical.put("Q",12);
        this.valueToNumerical.put("K",13);

        this.handValuesOccurrences = new HashMap<>();

        this.countHands = new HashMap<>();
        this.countHands.put("pair", 0.0);
        this.countHands.put("threeOfAKind", 0.0);
        this.countHands.put("fourOfAKind", 0.0);
        this.countHands.put("straight", 0.0);
        this.countHands.put("flush", 0.0);
        this.countHands.put("fullHouse", 0.0);
        this.countHands.put("straightFlush", 0.0);
        this.countHands.put("royalFlush", 0.0);
        this.countHands.put("highCard", 0.0);

        this.handProbabilitiesPercentage = new HashMap<>();

        this.handProbabilitiesPercentage.put("pair", 0.0);
        this.handProbabilitiesPercentage.put("threeOfAKind", 0.0);
        this.handProbabilitiesPercentage.put("fourOfAKind", 0.0);
        this.handProbabilitiesPercentage.put("straight", 0.0);
        this.handProbabilitiesPercentage.put("flush", 0.0);
        this.handProbabilitiesPercentage.put("fullHouse", 0.0);
        this.handProbabilitiesPercentage.put("straightFlush", 0.0);
        this.handProbabilitiesPercentage.put("royalFlush", 0.0);
        this.handProbabilitiesPercentage.put("highCard", 0.0);




    }

    /**
     * This method generates the deck to be used in this class
     * by generating the cards for each of the 4 suites:
     * hearts, spades, diamonds, and clubs.
     *
     */
    private void generateDeck(){
        generateSuite("heart");
        generateSuite("spade");
        generateSuite("diamond");
        generateSuite("club");
    }

    /**
     * This method generates all 13 cards of a suite:
     * Aces, 2's, 3's, 4's, 5's, 6's, 7's, 8's, 9's
     * 10's, Jacks, Queens, Kings.
     *
     * @param suite
     */
    private void generateSuite(String suite){

        for(int i = 2; i <= 10; i++) {
            deck.push(new Card(suite, "" + i));
        }
        deck.push(new Card(suite, "J"));
        deck.push(new Card(suite, "Q"));
        deck.push(new Card(suite, "K"));
        deck.push(new Card(suite, "A"));
    }

    /**
     * This method shuffles the deck of cards once.
     *
     */
    public void shuffleDeck(){

        int deckSize = deck.size();

        for(int i = 0; i < deckSize/2 && !deck.isEmpty(); i++){
            dealersRightHand.push(deck.pop());
        }
        for(int i = 0; i < deckSize/2 && !deck.isEmpty(); i++){
            dealersLeftHand.push(deck.pop());
        }
        int randomGrab = 0;

        for(int i = 0; i < deckSize; i += randomGrab * 2){
            randomGrab = (int)(Math.random() * 4) + 1;
            for(int j = 0; j < randomGrab && !dealersRightHand.isEmpty(); j++){
                deck.push(dealersRightHand.pop());
            }

            for(int k = 0; k < randomGrab && !dealersLeftHand.isEmpty(); k++){
                deck.push(dealersLeftHand.pop());
            }

        }

    }

    /**
     * This method draws a hand of cards with a specified hand size
     *
     * @param handSize the number of cards to be drawn for a hand
     */
    public void drawHand(int handSize){
        if(handSize <= 5){
            for(int i = 0; i < 5; i++){
                hand.add(deck.pop());
            }
            this.handValuesToMap();
            return;
        }
        if(handSize >= 7){
            for(int i = 0; i < 7; i++){
                hand.add(deck.pop());
            }
            this.handValuesToMap();
            return;
        }

    }

    /**
     * This function adds all the cards back into
     * deck, and then shuffles them 100 times to randomize it.
     *
     */
    public void resetDeck(){
        int handSize = hand.size();
        for(int i = handSize - 1; i >= 0; i--){
            deck.push(hand.remove(i));
        }
        for(int i = 0; i < 100; i++){
            shuffleDeck();
        }

    }

    /**
     * This method is for testing purposes only.
     * This method will randomly draw a hand from the deck,
     * where the hand size ranges from 5 to 7, a set number
     * of times.
     *
     * @param numTests the number of times that the drawHand method will be tested.
     */
    public void handTester(int numTests){
        for(int i = 0; i < numTests; i++){
            drawHand((int)(Math.random()*3)+5);
            resetDeck();
        }
    }

    /**
     * This method is for testing purpose only.
     * It will allow the user to print the current hand of cards that was drawn.
     *
     * @return a String of the values and the suites corresponding to each card in the hand
     */
    public String printHand(){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < hand.size(); i++){
            ret.append("[" + hand.get(i).getValue() + ", " + hand.get(i).getSuite() + "] ");
        }
        return ret.toString().trim();
    }

    /**
     * This method is for testing purposes only.
     * It will allow the user to print the remaining cards in the deck,
     * as well as the current number of cards within the deck.
     *
     * @return a String of the values and the suites corresponding to each card in the deck, and the deck size
     */
    public String printDeck(){
        StringBuilder ret = new StringBuilder();
        for(Card card : deck){
            ret.append("\n[" + card.getValue() + ", " + card.getSuite() + "] ");
        }
        return ret.toString().trim() + "\nTotal: " + deck.size();
    }

    /**
     * This method will print the probabilities that have been calculated for each hand
     * to a .csv file for its respective hand size.
     *
     * @param handSize the number of cards currently in the player's hand
     * @param sampleSpace the number of trials performed to calculate the probabilities
     * @throws IOException
     */
    public void printProbabilityToCSV(int handSize, int sampleSpace) throws IOException {

        this.calculateProbabilityOfHands(handSize, sampleSpace);

        Writer writer = new FileWriter("handSizeOf"+handSize+".csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("Hand Type: Probability (%)");
        bufferedWriter.newLine();
        for(Map.Entry<String,Double> entry : handProbabilitiesPercentage.entrySet()){
            //The Math.floor(entry.getValue() * 10000)/10000 is to truncate the repeating decimals
            bufferedWriter.write(entry.getKey() + ", " + Math.floor(entry.getValue() * 10000)/10000);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        writer.close();

        this.printProbabilitiesToConsole(handSize);

    }

    public void printProbabilitiesToConsole(int handSize){
        System.out.println("Hand Size: " + handSize + ", Hand Type, Probability (%)");
        for(Map.Entry<String,Double> entry : handProbabilitiesPercentage.entrySet()){
            //The Math.floor(entry.getValue() * 10000)/10000 is to truncate the repeating decimals
            System.out.println((entry.getKey()) + ", " + Math.floor(entry.getValue() * 10000)/10000);
        }
        System.out.println("\n\n");
    }


    /**
     * This function will calculate the number of occurrences of each hand, and
     * store it on the countHands HashMap.
     * Then, it will calculate the probability of these occurrences as a percentage,
     * and map that to the handProbabilitiesPercentage HashMap.
     *
     * @param handSize the number of cards per hand
     * @param sampleSpace the number of total trials performed
     */
    public void calculateProbabilityOfHands(int handSize, int sampleSpace){


        boolean[] hands = new boolean[8];
        for(int i = 0; i < sampleSpace; i++){
            this.resetDeck();
            this.drawHand(handSize);
            for(int j = 0; j < hands.length; j++){
                hands[j] = false;
            }
            if(isPair()){
                countHands.put("pair", countHands.getOrDefault("pair",0.0) + 1);
                hands[0] = true;
            }
            if(isThreeOfAKind()){
                countHands.put("threeOfAKind", countHands.getOrDefault("threeOfAKind",0.0) + 1);
                hands[1] = true;
            }
            if(isFourOfAKind()){
                countHands.put("fourOfAKind", countHands.getOrDefault("fourOfAKind",0.0) + 1);
                hands[2] = true;
            }
            if(isStraight()){
                countHands.put("straight", countHands.getOrDefault("straight",0.0) + 1);
                hands[3] = true;
            }
            if(isFlush()){
                countHands.put("flush", countHands.getOrDefault("flush",0.0) + 1);
                hands[4] = true;
            }
            if(isFullHouse()){
                countHands.put("fullHouse", countHands.getOrDefault("fullHouse",0.0) + 1);
                hands[5] = true;
            }
            if(isStraightFlush()){
                countHands.put("straightFlush", countHands.getOrDefault("straightFlush",0.0) + 1);
                hands[6] = true;
            }
            if(isRoyalFlush()){
                countHands.put("royalFlush", countHands.getOrDefault("royalFlush",0.0) + 1);
                hands[7] = true;
            }
            if(isHighCard(hands)){
                countHands.put("highCard", countHands.getOrDefault("highCard",0.0) + 1);

            }
        }

        for(Map.Entry<String,Double> entry : countHands.entrySet()){
            handProbabilitiesPercentage.put(entry.getKey(), entry.getValue()/sampleSpace * 100);
        }

    }

    /**
     * This function will determine whether the current hand is a pair or not.
     * Note: if there is more than one pair, then it will return false, since
     * we are not calculating double or triple pairs.
     *
     * @return true if there is exactly 1 pair in the hand, false otherwise
     */
    public boolean isPair(){

        boolean foundPair = false;

        for(Map.Entry<String,Integer> entry : handValuesOccurrences.entrySet()){
            if(entry.getValue() == 2 && foundPair){
                return false;
            }
            if(entry.getValue() == 2){
                foundPair = true;
            }
        }
        return foundPair;

    }

    /**
     * This function will determine whether the current hand is a three of kind,
     * meaning that the current hand has 3 cards of the same value
     *
     * @return true if this hand is a three of a kind, false otherwise
     */
    public boolean isThreeOfAKind(){

        boolean foundThree = false;

        for(Map.Entry<String,Integer> entry : handValuesOccurrences.entrySet()){
            if(entry.getValue() == 3 && foundThree){
                return false;
            }
            if(entry.getValue() == 3){
                foundThree = true;
            }
        }
        return foundThree;


    }


    /**
     * This function will determine whether the current hand is a four of kind,
     * meaning that the current hand has 4 cards of the same value
     *
     * @return true if this hand is a four of a kind, false otherwise
     */
    public boolean isFourOfAKind(){

        boolean foundFour = false;

        for(Map.Entry<String,Integer> entry : handValuesOccurrences.entrySet()){
            if(entry.getValue() == 4 && foundFour){
                return false;
            }
            if(entry.getValue() == 4){
                foundFour = true;
            }
        }
        return foundFour;


    }

    
    /**
     * This function will determine if the current hand is a straight,
     * and both Ace high straights and Ace low straights are considered
     *
     * @return true if the current hand is a straight, false otherwise
     */
    public boolean isStraight(){
        return isAceLowStraight() || isAceHighStraight();

    }

    /**
     * This function is a helper function to the <code>isStraight</code> method,
     * and it will determine whether a hand is a straight or not, including
     * an Ace high straight: 10-J-Q-K-A
     *
     * @return true if the current hand is a straight, false otherwise
     */
    private boolean isAceHighStraight(){
        /* I have created a new HashMap specifically for Ace high straights, because I originally
           equated the Ace to a 1. So here, an Ace will be equated to a 14, to be greater than the King.
         */
        HashMap<String,Integer> valueToNumericalForAceHigh = new HashMap<>();

        valueToNumericalForAceHigh.put("A",14);
        for(int i = 2; i <= 10; i++){
            valueToNumericalForAceHigh.put(""+i,i);
        }
        valueToNumericalForAceHigh.put("J",11);
        valueToNumericalForAceHigh.put("Q",12);
        valueToNumericalForAceHigh.put("K",13);

        this.sortHand(valueToNumericalForAceHigh);

        for(int i = 0; i < hand.size() - 1; i++){
            int card1Value = valueToNumericalForAceHigh.get(hand.get(i).getValue());
            int card2Value = valueToNumericalForAceHigh.get(hand.get(i + 1).getValue());
            if(card2Value - card1Value != 1){
                return false;
            }
        }
        return true;
    }

    /**
     * This function is a helper function to the <code>isStraight</code> method,
     * and it will determine whether a hand is a straight or not, including
     * an Ace low straight: A-1-2-3-4
     *
     * @return true if the current hand is a straight, false otherwise
     */
    private boolean isAceLowStraight(){
        this.sortHand(valueToNumerical);
        for(int i = 0; i < hand.size() - 1; i++){
            int card1Value = this.valueToNumerical.get(hand.get(i).getValue());
            int card2Value = this.valueToNumerical.get(hand.get(i + 1).getValue());
            if(card2Value - card1Value != 1){
                return false;
            }
        }
        return true;
    }

    /**
     * This function will determine if the current hand is a flush, meaning
     * that all cards are from the same suite.
     *
     * @return true if the current hand is a flush, false otherwise.
     */
    public boolean isFlush(){
        String suite = hand.get(0).getSuite();
        for(Card card : hand){
            if(!card.getSuite().equals(suite)){
                return false;
            }
        }
        return true;
    }

    /**
     * This function will determine if the current hand is a full house,
     * meaning that there are 2 cards of one value, and 3 cards of another value
     *
     * @return true if the current hand is a full house, false otherwise
     */
    public boolean isFullHouse(){

        boolean foundPair = false;
        boolean foundThree = false;

        for(Map.Entry<String,Integer> entry : handValuesOccurrences.entrySet()){
            if((entry.getValue() == 2 || entry.getValue() == 3) && (foundPair && foundThree)){
                return false;
            }
            if(entry.getValue() == 2){
                foundPair = true;
            }
            if(entry.getValue() == 3){
                foundThree = true;
            }
        }
        return foundPair && foundThree;
    }

    /**
     * This function will determine if the current hand is a straight flush,
     * meaning that it is both a straight and a flush, by calling the <code>isStraight</code>
     * and <code>isFlush</code> methods.
     *
     * @return true if the current hand is a straight flush, false otherwise
     */
    public boolean isStraightFlush(){

        return this.isStraight() && this.isFlush();
    }

    /**
     * This function will determine if the current hand is a royal flush,
     * meaning that it has a 10, Jack, Queen, King, and Ace all from the
     * same suite.
     *
     * @return true if the current hand is a royal flush, false otherwise.
     */
    public boolean isRoyalFlush(){

        this.sortHand(valueToNumerical);
        String currSuite = hand.get(0).getSuite();
        boolean containsA = false;
        boolean contains10 = false;
        boolean containsJ = false;
        boolean containsQ = false;
        boolean containsK = false;
        for(Card card : hand){
            if(!card.getSuite().equals(currSuite)){
                return false;
            }
            switch(card.getValue()){
                case "A":
                    containsA = true;
                    break;
                case "10":
                    contains10 = true;
                    break;
                case "J":
                    containsJ = true;
                    break;
                case "Q":
                    containsQ = true;
                    break;
                case "K":
                    containsK = true;
                    break;
            }
        }
        return containsA && contains10 && containsJ && containsQ && containsK;

    }



    /**
     * This function is for testing purposes only.
     * This function will determine if the current hand is a high card by
     * checking if the hand does not qualify as any other hand.
     *
     * @return true if the current hand is a high card, false otherwise.
     */
    public boolean isHighCard(){

        //Since a high card is a complement of all the other functions, I will just use a for loop
        //going from 1 to 8, because there are a total of 8 methods that determine a hand in this program

        return !(isPair() ||
        isThreeOfAKind() ||
        isFourOfAKind() ||
        isStraight() ||
        isFlush() ||
        isFullHouse() ||
        isStraightFlush() ||
        isRoyalFlush());


    }

    /**
     * This function will determine if the current hand is a high card by
     * traversing a boolean array that was filled out by <code>calculateProbabilityOfHands</code>
     * method for each of the hand types. If all the other hands are false, then it is a high card.
     *
     * @param hands the boolean array containing whether this hand qualifies as another type of hand
     * @return true if the current hand is a high card, false otherwise
     */
    public boolean isHighCard(boolean[] hands){
        boolean highCard = false;
        for(int i = 0; i < hands.length; i++){
            highCard = highCard || hands[i];
        }
        return !highCard;
    }

    /**
     * This method sorts the current hand by performing my implementation of
     * insertion sort in non-decreasing order, which uses a HashMap to compare
     * the values of the cards.
     *
     * @param valueToNumericalMap the HashMap containing the mappings of the cards to their respective numerical values
     */
    public void sortHand(HashMap<String,Integer> valueToNumericalMap){
        for(int i = 1; i < hand.size(); i++){
            Card key = hand.get(i);
            int j = i - 1;
            for(; j >= 0 && this.compareValue(key, hand.get(j), valueToNumericalMap) > 0; j--){
                hand.set(j + 1, hand.get(j));
            }
            hand.set(j + 1, key);
        }
    }


    /**
     * This function will compare the values of the cards and return a difference of their values,
     * which will determine which card has a greater value
     *
     * @param card1 a card to be compared
     * @param card2 another card to be compared
     * @param valueToNumericalMap the HashMap containing the mappings of the cards to their respective numerical values
     * @return a negative integer if card1 is greater in value, or 0 if card1 and card2 have equal values, and a positive integer if card2 is greater
     */
    private int compareValue(Card card1, Card card2, HashMap<String,Integer> valueToNumericalMap){
        return valueToNumericalMap.get(card2.getValue()) - valueToNumericalMap.get(card1.getValue());
    }

    /**
     * This function will keep track of the number occurrences for each card in a hand for a single trial,
     * by using a HashMap.
     */
    private void handValuesToMap(){
        handValuesOccurrences.clear();
        for(Card card : hand){
            handValuesOccurrences.put(card.getValue(), handValuesOccurrences.getOrDefault(card.getValue(), 0) + 1);
        }
    }

    /**
     * This function will print the probabilities to the terminal,
     * as well as print the probabilities of hand size 5 and hand size 7 to
     * their respective .csv files.
     *
     * @throws IOException
     */
    public void run() throws IOException {
        this.printProbabilityToCSV(5,100000);

        //This is to reset the counts and probabilities to start off fresh
        this.handValuesOccurrences.clear();
        this.countHands.clear();
        this.handProbabilitiesPercentage.clear();

        this.printProbabilityToCSV(7,100000);
    }

}
