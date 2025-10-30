package OOPs;

public class StaticTest {
    static String config;
    public static int square(int num){
        return num*num;
    }

    static{
        System.out.println("Loading Static Block...");
        config = "Default Configuratio";
    }
}

class LearnStatic{
    public static void main(String[] args) {
//        int result = StaticTest.square(5);
//        System.out.println(result);
//        StaticTest st = new StaticTest();
//        StaticTest st1 = new StaticTest();
    }
}
