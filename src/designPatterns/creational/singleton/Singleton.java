package designPatterns.creational.singleton;

public class Singleton {
    private static Singleton instance;  //Creating a private static instance

    private Singleton(){}   //Making Constructor private so that no other class can create its object

    //public method to access the instance
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    //To avoid cloning of Singleton Instance we override clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Singleton Instance cannot be cloned");
    }
}
