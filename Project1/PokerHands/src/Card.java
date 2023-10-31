import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * @author parthpatel0426
 *
 * This is a class used to create the Card objects, which have the following
 * attributes: suite and value.
 *
 */
public class Card {

    /**
     * This String attribute will store the type of suite
     * that the card is from, which can be one of the following:
     * hearts, spades, clubs, and diamonds.
     */
    private String suite;
    /**
     * This String attribute will store the value of
     * the card, which can be one of the following:
     * Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, and K.
     */
    private String value;

    /**
     * This constructor will initialize a Card object
     * based on its given suite and value.
     *
     * @param suite the suite that the card is from
     * @param value the value of the card
     */
    public Card(String suite, String value){
        this.suite = suite;
        this.value = value;
    }

    /**
     * This method will return the suite that this
     * card is from.
     *
     * @return a String for the suite that this card is from.
     */
    public String getSuite(){
        return this.suite;
    }

    /**
     * This method will return the value of this card.
     *
     * @return a String for the value of this card.
     */
    public String getValue(){
        return this.value;
    }




}
