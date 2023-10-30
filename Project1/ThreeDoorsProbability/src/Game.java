import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Game {
    private ArrayList<Integer> doors;

    public Game(){
        doors = new ArrayList<>();
        addDoors();
    }

    public int chooseDoor1(int door){

        int answer = (int)(Math.random()*3) + 1;
        if(door == answer){
            return 1;
        }
        else{
            return 0;
        }
    }

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




        //After these two doors are removed from the ArrayList, then the reveal will be at index 0
        //which is the only door that can be revealed




        /* Upon being shown that the door you choose is not the answer,
           you get to choose an
         */
        //if(door != answer && door == 1){
        if(reveal == 1){
            door = (int)(Math.random()*2) + 2;
        }
        //else if(door != answer && door == 2){
        else if(reveal == 2){
            coinFlip = (int)(Math.random()*2);
            if(coinFlip == 0){
                door = 1;
            }
            else{
                door = 3;
            }
        }
        //else if(door != answer && door == 3){
        else if(reveal == 3){
            door = (int)(Math.random()*2) + 1;
        }

        doors.clear();
        this.addDoors();

        if(door == answer){
            return 1;
        }
        else{
            return 0;
        }
    }

    public double findProbability1(){
        int probability = 0;
        int door = (int)(Math.random()*3) + 1;
        for(int i = 0; i < 100000; i++){
            probability += this.chooseDoor1(door);
        }
        return ((double)probability)/100000;
    }

    public double findProbability2(){
        int probability = 0;
        int door = (int)(Math.random()*3) + 1;
        for(int i = 0; i < 100000; i++){

            probability += this.chooseDoor2(door);
        }
        return ((double)probability)/100000;
    }

    //This is a basic linear search, since there are only 3 elements in "doors"
    private int searchDoors(int key){
        for(int i = 0; i < this.doors.size(); i++){
            if(this.doors.get(i) == key){
                return i;
            }
        }
        return -1;
    }

    private void addDoors(){
        for(int i = 0; i < 3; i++){
            doors.add(i + 1);
        }
    }

}
