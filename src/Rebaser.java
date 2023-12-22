/**
 * The Rebaser class stores a value in bases 2 through 16 and can convert it to bases 2 through 16. We discussed and worked together on all methods.
 * @author Benson Zhang and Serena Taxin
 */
public class Rebaser {

    private String storedValue;
    private static final int ASCII_CHAR_DIFF = 87;
    private static final String INPUTS = "ABCDEF0123456789";

    /**
     * Default constructor for Rebaser object. Sets stored value to 0.
     * @author Benson Zhang and Serena Taxin
     */
    public Rebaser(){
        storedValue = "0";
    }

    /**
     * Constructs a new Rebaser object with a stored value to be converted.
     * @param value A string containing the value to be converted.
     * @author Benson Zhang and Serena Taxin
     */
    public Rebaser(String value){
        if (verifyInput(value)){
            this.storedValue = value;
        }
        else {
            this.storedValue = "0";
        }
    }

    /**
     * Changes the stored value to the user-input value.
     * @param value Non-negative integer in base 16 or less.
     * @author Benson Zhang and Serena Taxin
     */
    public void setValue(String value){
        if (verifyInput(value)){
            this.storedValue = value;
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
     * Retrieves stored value.
     * @return Stored value as a string.
     * @author Benson Zhang and Serena Taxin
     */
    public String getValue(){
        return storedValue;
    }

    /**
     * Converts stored value (assumed in base 10) to a base n.
     * @param n The base value to be converted to.
     * @return The stored value in base n as a String.
     * @author Benson Zhang and Serena Taxin
     */
    public String convertToBaseN(int n){ // should just be convert to base 10 and then from base 10 to another base
        if (checkInvalid(storedValue, 10)) {
            return "-1"; // used to check if
        }
        String convertedString = "";
        int tempValue = Integer.parseInt(storedValue);
        while (tempValue > 0) {
            int remainder = (tempValue % n);
            char digit = Character.forDigit(remainder, n);
            convertedString = digit + convertedString;
            tempValue /= n;
        }

        return convertedString.isEmpty() ? "0" : convertedString;
    }
    /**
     * Converts the stored value (assumed in base n) to base 10.
     * @param n The base the stored value is assumed to be in.
     * @return The stored value in base 10.
     * @author Benson Zhang and Serena Taxin
     */

    public String convertToBase10(int n){
        if (checkInvalid(storedValue, n)){
            return ("-1");
        }
        int result = 0;
        String value = storedValue.toUpperCase();
        
        for (int i = 0; i < value.length(); i++){
           int digitValue = Character.digit(value.charAt(i), n);
            if (digitValue < 0 || digitValue >= n) {
                return "-1";
            }
            result = result * n + digitValue;
        }
        
        return Integer.toString(result);
    }

    private boolean checkInvalid(String num, int base){
        if (num.isEmpty()){
            return true;
        }
        num = num.toLowerCase();
        for (int i = 0; i < num.length(); i++){
            char c = num.charAt(i);
            int value;
            if (Character.isDigit(c)) {
                value = c - '0';
            } else if (Character.isLetter(c) && c >= 'a' && c <= 'f') {
                value = c - ASCII_CHAR_DIFF;
            } else {
                return true;
            }
            if (value >= base) {
                return true;
            }
        }
        return false;
    }
}
