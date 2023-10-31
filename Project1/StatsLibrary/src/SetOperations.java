import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

/**
 * @author Parth Patel
 * 
 * This <code>SetOperations</code> class creates a set structure, and 
 * provides the functions necessary to perform the basic set operations 
 * of: union, intersect, and complement.
 * 
 * This class also extends the ArrayList class, in order to access its
 * iterator to be able to traverse the set.
 *
 */
public class SetOperations extends ArrayList<Integer>{

    /**
     * Constructor that creates an ArrayList that will be used as a set,
     * by calling the constructor of the superclass.
     */
    public SetOperations(){
        super();
    }

    /**
     * This function will add an element to the set, while maintaining 
     * its property of only containing unique elements.
     * 
     * @param value is the integer that the user wishes to add to the set.
     * @return true if the element is new, false if the element already exists.
     */
    public boolean addElement(int value){
        if(this.isEmpty() || !this.binarySearch(value)){
            super.add(value);
            //this.mergeSort(0,set.size());
            Collections.sort(this);
            return true;
        }
        return false;
    }

    /**
     * This function will perform the union operation between this set
     * and set2, while maintaining the its property of only containing
     * unique elements. 
     * 
     * @param set2 is another set object
     * @return a set object of the union of both sets
     */
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

    /**
     * This function will perform the intersection operation between
     * this set and set2, while maintaining its property of only
     * containing unique elements. 
     * 
     * @param set2 is another set object
     * @return a set object of the intersect of both sets
     */
    public SetOperations intersect(SetOperations set2){
        SetOperations intersectSet = new SetOperations();
        for(Integer element : set2){
            if(binarySearch(element)){
                intersectSet.addElement(element);
            }
        }
        return intersectSet;
    }

    /**
     * This function will perform the complement operation between
     * this set and the sample space, while maintaining its property
     * of only containing unique elements.
     * 
     * @param sampleSpace is the sample space that this set is apart of
     * @return a set object of the complement of both sets
     */
    public SetOperations complement(SetOperations sampleSpace){
        SetOperations complementSet = new SetOperations();
        for(Integer element : sampleSpace){
            if(!binarySearch(element)){
                complementSet.addElement(element);
            }
        }
        return complementSet;
    }

    /**
     * This function overrides the original toString() method, 
     * and it will print out each element of this set. 
     *
     */
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

    /**
     * This function is my implementation of binary search that
     * is used to search for an element in the set.
     * 
     * @param key is the element that is going to be searched in the set
     * @return the index of where <code>key</code> is located
     */
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
