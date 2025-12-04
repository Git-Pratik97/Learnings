package testingCode;

import java.util.Vector;

public class StaticTest {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.printStatic();
        v.print();

        Car c = new Car();
        c.printStatic();
        c.print();

    }
}

class Vehicle{
    static int i;
    public static void printStatic(){
        System.out.println("Method Call from Vehicle Class Static Method... - " + i);
    }

    public void print(){
        System.out.println("Method Call from Vehicle Class Non-Static Method... - " + i);
    }
}

class Car extends Vehicle{
//    public static void printStatic(){
//        System.out.println("Method call from Car Class Static Method...");
//    }

    public void print(){
        System.out.println("Method call from Car Class Non-Static Method... - " + i);
    }
}