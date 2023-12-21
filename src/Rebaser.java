import java.lang.Math;
import java.util.HashMap;
public class Rebaser {

    private String storedValue;
    private static final int ASCII_DIFF = 87;
    private static final String INPUTS = "ABCDEF0123456789";
    private static final int[] CONV = {10, 11, 12, 13, 14, 15};

    private static final HashMap<Character, Integer> CONVERSION = new HashMap<Character, Integer>();
    static {
        CONVERSION.put('1', 1);
        CONVERSION.put('2', 2);
        CONVERSION.put('3', 3);
        CONVERSION.put('4', 4);
        CONVERSION.put('5', 5);
        CONVERSION.put('6', 6);
        CONVERSION.put('7', 7);
        CONVERSION.put('8', 8);
        CONVERSION.put('9', 9);
        CONVERSION.put('0', 0);
        CONVERSION.put('A', 10);
        CONVERSION.put('B', 11);
        CONVERSION.put('C', 12);
        CONVERSION.put('D', 13);
        CONVERSION.put('E', 14);
        CONVERSION.put('F', 15);
    }
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
            if (!INPUTS.contains(newStr.substring(i, i + 1))) {
                p = 0;
                break;
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
        this.storedValue = value;
    }

    /**
     * Retrieves stored value.
     * @return Stored value as a string.
     */
    public String getValue(){
        return storedValue;
    }

    /**
     * Converts stored value (assumed in base 10) to a base n.
     * @param n The base value to be converted to.
     * @return The stored value in base n as a String.
     */
    // CURRENTLY DOES NOT WORK.
    public String convertToBaseN(int n){ // should just be convert to base 10 and then from base 10 to another base
        if (checkValid(storedValue, 10)) {
            return ("-1"); // used to check if
        }
        String ans = "";
        String result = "";
        int remainder;
        int tAns = Integer.parseInt(storedValue);
        while (tAns >= n){
            remainder = tAns % n;
            tAns = tAns / n;
            ans += remainder;
        }
        ans += tAns;
        for (int i = ans.length() - 1; i >= 0; i--){
            result += ans.charAt(i);
        }
        return result; // placeholder
    }

    /**
     * Converts the stored value (assumed in base n) to base 10.
     * @param n The base the stored value is assumed to be in.
     * @return The stored value in base 10 .
     */

    public String convertToBase10(int n){
        if (checkValid(storedValue, n)){
            return ("-1");
        }
        int[] storedArr = new int[storedValue.length()];
        int returnVal = 0;
        for (int i = 0; i < storedValue.length(); i++){
            if (storedValue.toLowerCase().charAt(i) <= 102 || storedValue.toLowerCase().charAt(i) >= 97){
                storedArr[i] = (storedValue.toLowerCase().charAt(i) - ASCII_DIFF);
            }
            else {
                storedArr[i] = storedValue.toLowerCase().charAt(i);
            }
        }
        for (int i = storedArr.length - 1, j = 0; i >= 0; i--, j++){
            returnVal += storedArr[i] * (int) Math.pow(n, j);
        }
        return (returnVal + "");
    }

    private boolean checkValid(String num, int base){
        int p = 1;
        for (int i = 0; i < num.length(); i++){
            int testNum = num.toLowerCase().charAt(i);
            if (testNum > 10){
                testNum = testNum - ASCII_DIFF;
            }
            if (testNum > base){
                p *= 0;
            }
            else {
                p *= 1;
            }
        }
        return (p != 1);
    }


    private String convertToBaseTen(int n){ // Need to check if the "n" value is valid (ie. there can't be a base of 12 if we have an F in the stored value, should have something that checks for that input
        int[] arr = new int[storedValue.length()]; // creates new array that stores the value of each of the "place-values" of the input number
        double sum = 0; // sets a sum value default to 0
        for (int j = storedValue.length()-1, i = 0; j >= 0; j--, i++){ // cycles through the string array in reverse but sets it in new array starting from index 0
            arr[i] = CONVERSION.get(storedValue.charAt(j)); // checks and returns the respective value stored with the given key
            sum += arr[i]*Math.pow(n, i); // adds all the values to a sum that will be represented in base 10
        }
        return ((int) sum + ""); // returns the base 10 value of the stored number that was in base n
    }
}