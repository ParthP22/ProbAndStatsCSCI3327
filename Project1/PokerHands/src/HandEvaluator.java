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
 * to their respective .csv files
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



    //Note to self: make private later
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

        dealersRightHand = new Stack<>();
        dealersLeftHand = new Stack<>();


    }

    /**
     * 
     */
    private void generateDeck(){
        generateSuite("heart");
        generateSuite("spade");
        generateSuite("diamond");
        generateSuite("club");
    }

    /**
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
     * @param handSize
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
     * @param numTests
     */
    public void handTester(int numTests){
        for(int i = 0; i < numTests; i++){
            drawHand((int)(Math.random()*3)+5);
            resetDeck();
        }
    }

    /**
     * @return
     */
    public String printHand(){
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < hand.size(); i++){
            ret.append("[" + hand.get(i).getValue() + ", " + hand.get(i).getSuite() + "] ");
        }
        return ret.toString().trim();
    }

    /**
     * @return
     */
    public String printDeck(){
        StringBuilder ret = new StringBuilder();
        for(Card card : deck){
            ret.append("\n[" + card.getValue() + ", " + card.getSuite() + "] ");
        }
        return ret.toString().trim() + "\nTotal: " + deck.size();
    }

    /**
     * @param handSize
     * @param sampleSpace
     * @throws IOException
     */
    public void printProbabilityToCSV(int handSize, int sampleSpace) throws IOException {

        this.calculateProbabilityOfHands(handSize, sampleSpace);

        Writer writer = new FileWriter("handSizeOf"+handSize+".csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write("Hand Type, Probability (%)");
        bufferedWriter.newLine();
        for(Map.Entry<String,Double> entry : handProbabilitiesPercentage.entrySet()){
            bufferedWriter.write(entry.getKey() + ", " + entry.getValue());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        writer.close();

    }


    /**
     * @param handSize
     * @param sampleSpace
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
     * @return
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
     * @return
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
     * @return
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
     * @return
     */
    public boolean isStraight(){
        return isAceLowStraight() || isAceHighStraight();

    }

    /**
     * @return
     */
    private boolean isAceHighStraight(){
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
     * @return
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
     * @return
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
     * @return
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
     * @return
     */
    public boolean isStraightFlush(){

        return this.isStraight() && this.isFlush();
    }

    /**
     * @return
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
     * @return
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
     * @param hands
     * @return
     */
    public boolean isHighCard(boolean[] hands){
        boolean highCard = false;
        for(int i = 0; i < hands.length; i++){
            highCard = highCard || hands[i];
        }
        return !highCard;
    }

    //The method performs insertionSort to sort the hand in non-decreasing order
    /**
     * @param valueToNumericalMap
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
     * 
     */
    public void sortHand(){
        for(int i = 1; i < hand.size(); i++){
            Card key = hand.get(i);
            int j = i - 1;
            for(; j >= 0 && this.compareValue(key, hand.get(j), this.valueToNumerical) > 0; j--){
                hand.set(j + 1, hand.get(j));
            }
            hand.set(j + 1, key);
        }
    }



    /**
     * @param card1
     * @param card2
     * @param valueToNumericalMap
     * @return
     */
    private int compareValue(Card card1, Card card2, HashMap<String,Integer> valueToNumericalMap){
        return valueToNumericalMap.get(card2.getValue()) - valueToNumericalMap.get(card1.getValue());
    }

    /**
     * 
     */
    private void handValuesToMap(){
        handValuesOccurrences.clear();
        for(Card card : hand){
            handValuesOccurrences.put(card.getValue(), handValuesOccurrences.getOrDefault(card.getValue(), 0) + 1);
        }
    }

    /**
     * @throws IOException
     */
    public void run() throws IOException {
        this.printProbabilityToCSV(5,100000);
        this.printProbabilityToCSV(7,100000);
    }

}
