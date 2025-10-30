package functionalPrograming;

import com.sun.tools.javac.Main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Raj", "Ravi", "Kamal", "Mohan", "Kareena");

        Consumer<String> consume = (name) -> System.out.println(name);

        names.forEach(consume);
    }
}
