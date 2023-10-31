import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author parthpatel0426
 *
 * This program will compute the probabilites of the Monte's Three Door Problem.
 *
 * The <code>chooseDoor1</code> method will calculate the probability of the selecting a door
 * and choosing not to change your answer.
 *
 * The <code>chooseDoor2</code> method will calculate the probability of the selecting a door
 * and then changing your answer after one door is revealed to be a dud.
 *
 * The <code>run</code> method will print out both probabilities as percentages.
 *
 */

/* Answer to question 2.20 on page 34
   a. If the contestant has no idea which curtains hide the various prizes and selects a curtain at
   random, assign reasonable probabilities to the simple events and calculate the probability
   that the contestant selects the curtain hiding the nice prize.

   Answer: the probability that the contestant selects the curtain hiding the
   prize is 1/3, since there are 3 possible events in the sample space, where
   the probability of each is 1/3.

   b. Before showing the contestant what was behind the curtain initially chosen, the game show
   host would open one of the curtains and show the contestant one of the duds (he could
   always do this because he knew the curtain hiding the good prize). He then offered the
   contestant the option of changing from the curtain initially selected to the other remaining
   unopened curtain. Which strategy maximizes the contestant’s probability of winning the
   good prize: stay with the initial choice or switch to the other curtain? In answering the
   following sequence of questions, you will discover that, perhaps surprisingly, this question
   can be answered by considering only the sample space above and using the probabilities
   that you assigned to answer part (a)

   Answer: The contestant's probability of winning the good prize actually doubles to 2/3 instead
   of 1/3, because when being allowed to switch after seeing which door had a dud, your probability
   of winning on your second chance will increase to 1/2, since you now only have 2 choices, as
   opposed to having 3 choices.
 */

public class Game {
    /**
     * <code>doors</code> is an <code>ArrayList</code> that stores each of the 3 doors,
     * that will be picked from in the <code>chooseDoor2</code> method.
     */
    private ArrayList<Integer> doors;

    /**
     * <code>Game</code> is the constructor for this class, which will allow the user
     * to run the methods of this class. Also, <code>doors</code> is initialized and
     * filled by the <code>addDoors</code> method.
     */
    public Game(){
        doors = new ArrayList<>();
        addDoors();
    }

    /**
     * This method will run one session of the Monte's Three Doors game,
     * where a player will pick a door and will not be allowed to change
     * their answer.
     *
     * @param door the door that is chosen
     * @return 1 if the door is the correct one, 0 otherwise
     */
    public int chooseDoor1(int door){

        int answer = (int)(Math.random()*3) + 1;
        if(door == answer){
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * This method will run one session of the Monte's Three Doors game,
     * where a player will pick a door and will be allowed to change
     * their answer after a door is revealed to be a dud.
     *
     * @param door the door that is chosen
     * @return 1 if the door is the correct one, 0 otherwise
     */
    public int chooseDoor2(int door){

        int coinFlip = 0;
        int answer = (int)(Math.random()*3) + 1;
        int reveal = 0;


        if(door == answer){

            doors.remove(this.searchDoors(door));
            coinFlip = (int)(Math.random() * 2);
            reveal = doors.remove(coinFlip);

        }
        else{
            doors.remove(this.searchDoors(door));
            doors.remove(this.searchDoors(answer));
            reveal = doors.remove(0);
        }


        /* This series of if and if-else statements
         * are used to switch the player's answer
         * to a different door, based on what the player's
         * answer is, and based on which door is revealed
         */
        if(reveal == 1){
            if(door == 2){
                door = 3;
            }
            else if(door == 3){
                door = 2;
            }
        }
        else if(reveal == 2){
            if(door == 1){
                door = 3;
            }
            else if(door == 3){
                door = 1;
            }
        }
        else if(reveal == 3){
            if(door == 1){
                door = 2;
            }
            else if(door == 2){
                door = 1;
            }
        }


        /* These two methods will reset the
         * doors ArrayList, in order to prepare
         * for the next session
         */
        doors.clear();
        this.addDoors();

        /* If the player's new answer is correct,
         * then return 1. Else, return 0
         */
        if(door == answer){
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * This method will run 100,000 trials to calculate the probability of winning
     * the Three Doors Problem if you do not switch doors.
     *
     * @return double value for the probability of winning after choosing 1 door
     */
    public double findProbability1(){
        int probability = 0;
        int door = (int)(Math.random()*3) + 1;
        for(int i = 0; i < 100000; i++){
            probability += this.chooseDoor1(door);
        }
        return ((double)probability)/100000;
    }

    /**
     * This method will run 100,000 trials to calculate the probability of winning
     * the Three Doors Problem if you do switch doors.
     *
     * @return double value for the probability of winning after switching doors
     */
    public double findProbability2(){
        int probability = 0;
        int door = (int)(Math.random()*3) + 1;
        for(int i = 0; i < 100000; i++){

            probability += this.chooseDoor2(door);
        }
        return ((double)probability)/100000;
    }

    /**
     * This <code>private</code> method will perform a basic linear search to find the index of a specific
     * door in <code>doors</code>
     *
     * @param key int value for whichever door number that we are searching for
     * @return index of the door in <code>doors</code>
     */
    private int searchDoors(int key){
        for(int i = 0; i < this.doors.size(); i++){
            if(this.doors.get(i) == key){
                return i;
            }
        }
        return -1;
    }

    /**
     * This <code>private</code> method will add all the doors back into <code>doors</code>
     * so that it can be used for the next session
     */
    private void addDoors(){
        for(int i = 0; i < 3; i++){
            doors.add(i + 1);
        }
    }

    /**
     * This method will allow the user to run the methods to calculate the probabilities of
     * both scenarios of the Monte's Three Doors Problem, and then it will print the results
     * as percentages.
     */
    public void runGame(){
        System.out.println("The probability of winning after not switching doors: " + this.findProbability1() * 100 + "%");
        System.out.println("The probability of winning after switching doors: " + this.findProbability2() * 100 + "%");
    }

}
