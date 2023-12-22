public class RebaserTester {
    public static void main(String[] args){
        Rebaser test = new Rebaser("f");
        System.out.println(test.convertToBase10(13));
        test.setValue("d");
        System.out.println(test.convertToBaseN(5));
    }
}
