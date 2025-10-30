package randomTests;

@FunctionalInterface
public interface AddTwoNums {
    public int calculate(int a, int b);
}

@FunctionalInterface
interface PrintEmptyLambda{
    public void print();
}

class TestingLambda{
    public static void main(String[] args) {
        AddTwoNums addTwoNums = (a, b) -> 2*(a + b);

        System.out.println(addTwoNums.calculate(40, 50));


    }
}
