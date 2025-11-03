package collectionFramework;

import java.sql.SQLOutput;

public class GenericTests {
    public static void main(String[] args) {
        LearnGeneric<Integer> intLearn = new LearnGeneric<>();
        intLearn.value = 100;
        intLearn.getType();

        System.out.println(intLearn.getValue());

        LearnGeneric<String> strLearn = new LearnGeneric<>();
        strLearn.value = "Generic String";

        strLearn.getType();
        System.out.println(strLearn.getValue());
    }
}

class LearnGeneric<T> {
    T value;

    public void getType(){
        System.out.println(value.getClass().getName());
    }

    public T getValue(){
        return this.value;
    }
}