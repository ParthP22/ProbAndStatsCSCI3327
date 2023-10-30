import java.util.ArrayList;
import java.util.Deque;

public class Card {

    private String suite;
    private String value;

    public Card(String suite, String value){
        this.suite = suite;
        this.value = value;
    }

    public String getSuite(){
        return this.suite;
    }
    public String getValue(){
        return this.value;
    }

    public Card drawCard(Deque<Card> cards){

        return cards.pop();
    }

}
