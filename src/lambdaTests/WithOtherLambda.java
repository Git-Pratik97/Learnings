package lambdaTests;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class WithOtherLambda {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Mohan", "Garcy", "Rohan", "Anmol", "Daron");
        Consumer<String> method = n -> System.out.println(n);

        names.forEach(method);
    }
}
