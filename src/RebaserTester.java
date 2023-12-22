public class RebaserTester {
    public static void main(String[] args){
        Rebaser test = new Rebaser("f1928");
        System.out.println(test.convertToBase10(16));
        test.setValue("12311092");
        System.out.println(test.convertToBaseN(16));
    }
}
