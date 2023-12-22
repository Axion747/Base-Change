public class RebaserTester {
    public static void main(String[] args){
        Rebaser test = new Rebaser("1872d6");
        System.out.println(test.convertToBase10(15));
        test.setValue("192934");
        System.out.println(test.convertToBaseN(12));
    }
}
