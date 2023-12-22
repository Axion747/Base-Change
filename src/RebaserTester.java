public class RebaserTester {
    public static void main(String[] args){
        Rebaser test = new Rebaser("");
        System.out.println(test.convertToBase10(0));
        test.setValue("192934");
        System.out.println(test.convertToBaseN(12));
    }
}
