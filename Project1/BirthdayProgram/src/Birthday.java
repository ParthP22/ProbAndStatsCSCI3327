import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/* Note to self (DELETE LATER):
   For Birthday, instead of using MM/DD format, just assign a random number from
   1 to 365 for the birthday. Then, I can tally up the shared birthdays in a map.
   I can't do this with Birthday objects where I have a MM/DD, since when
   I put them in a map, I won't be able to properly tally them up, because
   none of the objects are the "same": they're all stored in different places
   in memory. So, when I use map.getOrDefault(*birthday object*,0) + 1, I will always
   get 0 + 1 (which equals 1) for my value for EVERY object, instead of the occurrences
   being properly tallied up
 */

public class Birthday {

    public Birthday(){

    }

    /*
    private int month;
    private int day;

    public Birthday(int month, int day){
        this.month = month;
        this.day = day;
    }

    public static ArrayList<Birthday> generateRandomBirthday(int totalBirthdays){
        ArrayList<Birthday> birthdays = new ArrayList<>();
        for(int i = 0; i < totalBirthdays; i++){
            int month = generateMonth();
            birthdays.add(new Birthday(month, generateDay(month)));

        }
        return birthdays;
    }

    public static HashMap<Birthday,Integer> birthdayOccurrences(ArrayList<Birthday> birthdays){
        HashMap<Birthday,Integer> birthdayOccurrences = new HashMap<>();
        for(int i = 0; i < birthdays.size(); i++){
            birthdayOccurrences.put(birthdays.get(i), birthdayOccurrences.getOrDefault(birthdays.get(i), 0) + 1);
            System.out.println(birthdayOccurrences.get(birthdays.get(i)));
        }
        return birthdayOccurrences;
    }

    public static int numberOfSharedBirthdays(HashMap<Birthday,Integer> birthdayOccurrences){
        int count = 0;
        for(Map.Entry<Birthday,Integer> entry : birthdayOccurrences.entrySet()){

            if(entry.getValue() > 1){
                count += entry.getValue();

            }
        }
        return count;
    }

    private static int generateMonth(){
        return (int)(Math.random()*12)+1;
    }
    private static int generateDay(int month){
        if(month == 1 || month == 3 || month == 5 || month == 7 ||
                month == 8 || month == 10 || month == 12){
            return (int)(Math.random()*31)+1;
        }
        if(month == 2){
            return (int)(Math.random()*28)+1;
        }
        if(month == 4 || month == 6 || month == 9 || month == 11){
            return (int)(Math.random()*30)+1;
        }
        return -1;
    }


     */

}
