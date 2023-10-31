/**
 * @author Parth Patel
 *
 * This <code>IllegalProbabilityException</> class extends the Exception class
 * and is used any time there is an impossible probability or a probability
 * that is out of bounds.
 *
 */
public class IllegalProbabilityException extends Exception{

    /**
     * This exception is used for any time there is a probability
     * that looks impossible or is out of bounds.
     *
     * @param error a String that represents the error message
     */
    public IllegalProbabilityException(String error){
        super(error);
    }
}
