public class RebaserTester {
    public static void main(String[] args){
        Rebaser test = new Rebaser();
        System.out.println(test.getValue());
        System.out.println(test.convertToBase10(10));
        test.setValue("13f");
        System.out.println(test.convertToBaseN(12));
    }
}
