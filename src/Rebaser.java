import java.lang.Math;
public class Rebaser {

    private String storedValue;
    private static final int ASCII_CHAR_DIFF = 87;
    private static final int ASCII_NUM_DIFF = 48;
    private static final String INPUTS = "ABCDEF0123456789";

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
    public String convertToBaseN(int n){ // should just be convert to base 10 and then from base 10 to another base
        if (checkInvalid(storedValue, 10)) {
            return ("-1"); // used to check if
        }
        String ans = "";
        String result = "";
        int remainder;
        int tAns = Integer.parseInt(storedValue);
        while (tAns >= n) {
            remainder = (tAns % n);
            if (remainder > 9) {
                remainder = (char) (remainder + ASCII_CHAR_DIFF);
            }
            ans += remainder + "";
            tAns = tAns / n;
        }
        if (tAns >= 10){
            ans += (char) (tAns + ASCII_CHAR_DIFF);
        }
        else {
            ans += tAns;
        }
        for (int i = ans.length() - 1; i >= 0; i--){
            result += (char) (ans.charAt(i));
        }
        return result; // placeholder
    }
    /**
     * Converts the stored value (assumed in base n) to base 10.
     * @param n The base the stored value is assumed to be in.
     * @return The stored value in base 10 .
     */

    public String convertToBase10(int n){
        if (checkInvalid(storedValue, n)){
            return ("-1");
        }
        int result = 0;
        String value = storedValue.toLowerCase();
        int[] arr = new int[storedValue.length()];
        int tempInt;
        for (int i = 0; i < storedValue.length(); i++){
            tempInt = value.charAt(i);
            if (value.charAt(i) >= 97){
                tempInt = ((int) value.charAt(i) - ASCII_CHAR_DIFF);
            }
            arr[i] = tempInt - ASCII_NUM_DIFF;
        }
        int p = 0;
        for (int j = arr.length - 1; j >= 0; j--){
            result += (int) (arr[j] * Math.pow(n, p));
            p++;
        }
        return (result + "");
    }

    private boolean checkInvalid(String num, int base){
        if (num.isEmpty()){
            return true;
        }
        int p = 1;
        for (int i = 0; i < num.length(); i++){
            int testNum = num.toLowerCase().charAt(i) - ASCII_NUM_DIFF;
            if (testNum > 10){
                testNum = testNum - ASCII_CHAR_DIFF;
            }
            if (testNum >= base){
                p = 0;
            }
        }
        return (p == 0);
    }
}