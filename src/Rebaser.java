import java.util.Arrays;
import java.lang.Math;
import java.util.HashMap;
public class Rebaser {

    private String storedValue;
    private static final String INPUTS = "ABCDEF0123456789";
    private static final int[] CONV = {10, 11, 12, 13, 14, 15};

    private static final HashMap<String, Integer> CONVERSION = new HashMap<String, Integer>();

    /**
     * Default constructor for Rebaser object. Sets stored value to 0.
     */
    public Rebaser(){
        storedValue = "0";
    }

    /**
     * Constructor for Rebaser object. Sets stored value to value.
     * @param value A string containing
     */
    public Rebaser(String value){ // do we need to check for integer inputs? Or will java change it to String by default.
        if (verifyInput(value)){
            this.storedValue = (String) value;
        }
        else {
            this.storedValue = "0";
        }
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

    private static int conversion_f(String input){
        char[] arr1 = new char[input.length()];
        int[] arr = new int[input.length()];
        CONVERSION.put("A", 10);
        CONVERSION.put("B", 11);
        CONVERSION.put("C", 12);
        CONVERSION.put("D", 13);
        CONVERSION.put("E", 14);
        CONVERSION.put("F", 15);

        for (int i = 0; i < input.length(); i++){
            arr1[i] = input.charAt(i);
        }
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

    // Just for testing purposes
    public static void main (String[] args){
    }

}