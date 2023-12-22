/** The Rebaser class stores a value in bases 2 through 16 and can convert it to bases 2 through 16. We discussed and worked together on all methods. @author Benson Zhang and Serena Taxin*/

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
     * Constructs a new Rebaser object with a stored value to be converted.
     * @param value A string containing the value to be converted.
     */
    public Rebaser(String value){
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
        String upperCaseInput = input.toUpperCase();
        int isValid = 1;
        boolean isValidResult;
        for (int i = 0; i < input.length(); i++){
            if (!INPUTS.contains(upperCaseInput.substring(i, i + 1))) {
                isValid = 0;
                break;
            }
        }
        isValidResult = (isValid == 1);
        return (isValidResult);
    }
    /**
     * Changes the stored value to the user-input value.
     * @param value Non-negative integer in base 16 or less.
     */
    public void setValue(String value){
       if (verifyInput(value)){
            this.storedValue = value;
        }
        else {
            this.storedValue = 0;
        }
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
        String convertedString = "";
        String reverseConvertedString = "";
        int remainder;
        int tempValue = Integer.parseInt(storedValue);
        while (tempValue >= n) {
            remainder = (tempValue % n);
            if (remainder > 9) {
                remainder = (char) (remainder + ASCII_CHAR_DIFF);
            }
            convertedString += remainder + "";
            tempValue = tempValue / n;
        }
        if (tempValue >= 10){
            convertedString += (char) (tempValue + ASCII_CHAR_DIFF);
        }
        else {
            convertedString += tempValue;
        }
        for (int i = convertedString.length() - 1; i >= 0; i--){
            reverseConvertedString += (char) (convertedString.charAt(i));
        }
        return reverseConvertedString; // placeholder
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
        int[] digitValues = new int[storedValue.length()];
        int numericValue;
        for (int i = 0; i < storedValue.length(); i++){
            numericValue = value.charAt(i);
            if (value.charAt(i) >= 97){
                numericValue = ((int) value.charAt(i) - ASCII_CHAR_DIFF);
            }
            digitValues[i] = numericValue - ASCII_NUM_DIFF;
        }
        int exponent = 0;
        for (int j = digitValues.length - 1; j >= 0; j--){
            result += (int) (digitValues[j] * Math.pow(n, exponent));
            exponent++;
        }
        return (result + "");
    }

    private boolean checkInvalid(String num, int base){
        if (num.isEmpty()){
            return true;
        }
        int isValid = 1;
        for (int i = 0; i < num.length(); i++){
            int testNum = num.toLowerCase().charAt(i) - ASCII_NUM_DIFF;
            if (testNum > 10){
                testNum = testNum - ASCII_CHAR_DIFF;
            }
            if (testNum >= base){
                isValid = 0;
            }
        }
        return (isValid == 0);
    }
}
