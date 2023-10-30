import java.util.ArrayList;
import java.util.HashMap;

public class SetOperations<E> {

    public ArrayList<E> findUnion(ArrayList<E> set1, ArrayList<E> set2){
        ArrayList<E> union = new ArrayList<>();
        HashMap<E,Integer> map = new HashMap<>();

        for(int i = 0, j = 0; i < set1.size() && j < set2.size();){
            if(!map.containsKey(set1.get(i))){
                
            }
        }

        return union;
    }

}
