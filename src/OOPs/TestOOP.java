package OOPs;

public class TestOOP {
    public static void main(String[] args) {
        A a = new B();
        a.m1();
    }
}

class A{
    public void m1(){
        System.out.println("In m1 A");
    }
}

class B extends A{
    public void m1(){
        System.out.println("In m1 B");
    }

    public void m2(){
        System.out.println("In m2 B");
    }
}
