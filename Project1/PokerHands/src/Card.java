import java.util.ArrayList;
import java.util.Deque;

/**
 * @author parthpatel0426
 *
 */
public class Card {

    /**
     * 
     */
    private String suite;
    /**
     * 
     */
    private String value;

    /**
     * @param suite
     * @param value
     */
    public Card(String suite, String value){
        this.suite = suite;
        this.value = value;
    }

    /**
     * @return
     */
    public String getSuite(){
        return this.suite;
    }
    /**
     * @return
     */
    public String getValue(){
        return this.value;
    }

    /**
     * @param cards
     * @return
     */
    public Card drawCard(Deque<Card> cards){

        return cards.pop();
    }

}
