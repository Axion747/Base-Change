public class RebaserTester {
    public static void main(String[] args){
        System.out.println("Not completed. :)");
        System.out.println((int) 'a' - 87);
        Rebaser test = new Rebaser("AB");
        System.out.println(test.convertToBase10(13));
        test.setValue("101");
        System.out.println(test.convertToBaseN(2));
    }
}
