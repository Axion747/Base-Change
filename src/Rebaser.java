import java.util.Arrays;
import java.lang.Math;
public class Rebaser {

    private String storedValue;
    private static final char[] LIST_OF_INPUTS = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final String LIST_INPUTS = "0123456789ABCDEF";
    public Rebaser(){
        storedValue = "0";
    }

    public Rebaser(String value){
        this.storedValue = value;
    }

    private boolean verifyInput(String input){
        if (input.isEmpty()){
            return false;
        }
        String newStr = input.toUpperCase();
        int p = 1;
        boolean ans;
        for (int i = 0; i < input.length(); i++){
            if (LIST_INPUTS.contains(newStr.substring(i, i+1))){
                p *= 1;
            }
            else{
                p *= 0;
            }
        }
        return ((p == 1) ? (ans = true) : (ans = false));
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

    public String convertToBase10(int n){
        return ""; // placeholder
    }

    // Just for testing purposes
    public static void main (String[] args){
    }

}