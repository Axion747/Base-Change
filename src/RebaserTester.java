public class RebaserTester {
    public static void main(String[] args){
//        System.out.println("Not completed. :)");
//        System.out.println(12/11);
        Rebaser test = new Rebaser("AB");
//        System.out.println(test.convertToBase10(13));
        test.setValue("BF");
        System.out.println(test.convertToBaseN(12));
    }
}
