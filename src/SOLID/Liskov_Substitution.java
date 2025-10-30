package SOLID;

public class Liskov_Substitution {
    public static void main(String[] args) {
        System.out.println("Testing LSP....");
    }
}

interface Bird{
    void eat();
}

interface FlyingBird extends Bird {
    void fly();
}

class BirdSanctury{
    public void letBirdFly(FlyingBird bird){
        bird.fly();
    }
}