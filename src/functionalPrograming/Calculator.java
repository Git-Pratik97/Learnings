package functionalPrograming;
//import java.lang.FunctionalInterface;


@FunctionalInterface
public interface Calculator {
    public int compute(int a, int b);
}


class FunctionalInterfaceTest {
    public static void main(String[] args) {
        Calculator calculator = new Calculator() {
            @Override
            public int compute(int a, int b) {
                return 2*(a + b);
            }
        };

        System.out.println(calculator.compute(2, 6));
    }
}
