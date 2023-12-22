public class RebaserTester {
    public static void main(String[] args){
        Rebaser test = new Rebaser("123094");
        System.out.println(test.convertToBase10(2));
        test.setValue("13");
        System.out.println(test.convertToBaseN(2));
    }
}
