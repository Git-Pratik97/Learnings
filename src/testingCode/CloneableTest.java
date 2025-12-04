package testingCode;

public class CloneableTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
//        p1.clone();

        Person1 p2 = new Person1();
        Person1 p3 = (Person1) p2.clone();
    }
}

class Person{
    int age = 25;
}

class Person1 implements Cloneable{
    private int age = 30;

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
