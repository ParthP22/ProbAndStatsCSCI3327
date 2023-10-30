import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;


public class SetOperations extends ArrayList<Integer>{

    public SetOperations(){
        super();
    }

    public boolean addElement(int value){
        if(this.isEmpty() || !this.binarySearch(value)){
            super.add(value);
            //this.mergeSort(0,set.size());
            Collections.sort(this);
            return true;
        }
        return false;
    }

    public SetOperations union(SetOperations set2){
        SetOperations unionSet = new SetOperations();
        for(Integer element : this){
            unionSet.addElement(element);
        }

        for(Integer element : set2){
            unionSet.addElement(element);
        }

        return unionSet;
    }

    public SetOperations intersect(SetOperations set2){
        SetOperations intersectSet = new SetOperations();
        for(Integer element : set2){
            if(binarySearch(element)){
                intersectSet.addElement(element);
            }
        }
        return intersectSet;
    }

    public SetOperations complement(SetOperations sampleSpace){
        SetOperations complementSet = new SetOperations();
        for(Integer element : sampleSpace){
            if(!binarySearch(element)){
                complementSet.addElement(element);
            }
        }
        return complementSet;
    }

    @Override
    public String toString(){
        if(super.size() == 0){
            return "Empty Set";
        }
        StringBuilder setString = new StringBuilder();
        for(int i = 0; i < super.size(); i++){
            setString.append(super.get(i) + ", ");
        }
        //The substring to remove the comma and space at the end to create a clean output
        return setString.toString().substring(0,setString.length() - 2);
    }

    private boolean binarySearch(int key){
        int left = 0;
        int right = super.size() - 1;

        while(left <= right){
            int mid = (left + right)/2;
            if(super.get(mid) == key){
                return true;
            }
            if(super.get(mid) < key){
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }



}
