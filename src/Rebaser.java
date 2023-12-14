import java.util.Arrays;
import java.lang.Math;
public class Rebaser {

    private String storedValue;
    private static final String INPUTS = "0123456789ABCDEF";

    /**
     * Default constructor for Rebaser object. Sets stored value to 0.
     */
    public Rebaser(){
        storedValue = "0";
    }

    /**
     * Constructor for Rebaser object. Sets stored value to value.
     * @param value
     */
    public Rebaser(String value){ // do we need to check for integer inputs? Or will java change it to String by default.
        this.storedValue = (String) value;
    }

    private boolean verifyInput(String input){
        if (input.isEmpty()){
            return false;
        }
        String newStr = input.toUpperCase();
        int p = 1;
        boolean ans;
        for (int i = 0; i < input.length(); i++){
            if (INPUTS.contains(newStr.substring(i, i+1))){
                p *= 1;
            }
            else{
                p *= 0;
            }
        }
        ans = (p == 1);
        return (ans);
    }
    /**
     * Changes the stored value to the user-input value.
     * @param value Non-negative integer in base 16 or less.
     */
    public void setValue(String value){

    }

    /**
     * Retrieves stored value.
     * @return Stored value as a string.
     */
    public String getValue(){
        return ""; // place holder
    }

    /**
     * Converts stored value (assumed in base 10) to a base n.
     * @param n The base value to be converted to.
     * @return The stored value in base n as a String.
     */

    public String convertToBaseN(int n){
        return ""; // placeholder
    }

    /**
     *
     * @param n
     * @return
     */
    public String convertToBase10(int n){
        return ""; // placeholder
    }

    /**
     *
     * @param args
     */
    // Just for testing purposes
    public static void main (String[] args){
    }

}