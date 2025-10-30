package designPatterns.structural;

//decorator Design pattern adds a new behaviour to objects dynamically without modifying existing code
//Instead of extending classes through inheritance,
// it relies on composition to wrap objects with additional functionality


//Client code for Coffee Shop accumulating all the Decorators
public class DecoratorPattern {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println("--> " + coffee.getDescription() + " = $" + coffee.getCost());

        coffee = new Sugar(coffee);
        System.out.println("--> Adding Sugar : " + coffee.getDescription() + " = $" + coffee.getCost());

        coffee = new WhippedCream(coffee);
        System.out.println("--> Adding Whipped Cream : " + coffee.getDescription() + " = $" + coffee.getCost());
    }
}

//Defining the base class
interface Coffee{
    String getDescription();
    double getCost();
}

//Concrete Component: Plain Coffee
class BasicCoffee implements Coffee{

    /**
     * @return
     */
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return 50;
    }
}

//Creating a abstract Decorator
abstract class CoffeeDecorator implements Coffee{
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return coffee.getCost();
    }
}

//Concrete Decorator : Adds Sugar
class Sugar extends CoffeeDecorator{

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    /**
     * @return
     */
    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return super.getCost() + 5;
    }
}

//Concrete Decorator: Adds Whipped Cream
class WhippedCream extends CoffeeDecorator{

    public WhippedCream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    /**
     * @return
     */
    @Override
    public double getCost() {
        return super.getCost() + 15;
    }
}


