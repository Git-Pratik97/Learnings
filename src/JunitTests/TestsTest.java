package JunitTests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;

//@ExtendWith(Mockito.class)
public class TestsTest {

    private Calculator calc;

    @BeforeAll
    static void initializeSuite(){
        System.out.println("Suite Setup : Establishing all shared resources.");
    }

    @BeforeEach
    void setup(){
        calc = new Calculator();
        System.out.println("Test Setup : Setting up Calculator");
    }

    @Test
    void testAddition(){
        System.out.println("Running Test on Addition");
        Assertions.assertEquals(5, calc.addInt(2, 3), "Test is Failed : Addition is not correct");
    }

    @Test
    void testSubstract(){
        System.out.println("Running Test on substraction");
        Assertions.assertEquals(10, calc.suntract(10, 20), "Test is failed : Subtraction is not correct");
    }

    @AfterEach
    void teardown(){
        System.out.println("Test Setup closing : Tear down Calculator");
    }

    @AfterAll
    static void finalizeMethods() {
        System.out.println("Tests finished : Closing all resources");
    }

    public static void main(String[] args) {
        System.out.println("Running tests");
        TestsTest test = new TestsTest();

    }

}

class Calculator{
    public int addInt(int a, int b){
        return a + b;
    }

    public int suntract(int a, int b){
        return Math.abs(a - b);
    }
}
