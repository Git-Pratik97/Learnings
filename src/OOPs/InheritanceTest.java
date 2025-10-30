package OOPs;

import java.io.Serializable;

class Vehicle{
    public void makeSound(){
        System.out.println("Vehicles Makes Sound...");
    }
}

class Car extends Vehicle{
    public void makeSound(){
        System.out.println("Car Makes Bigger Sound...");
    }
}

class SportsCar extends Car{
    @Override
    public void makeSound() {
        System.out.println("Sports Cars Makes even bigger sound...");
    }
}

class BigCar extends Car{}

public class InheritanceTest {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.makeSound();

        Vehicle sportsCar = new SportsCar();
        sportsCar.makeSound();
    }

    class serial implements Serializable{

    }
}
