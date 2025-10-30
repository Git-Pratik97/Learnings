package designPatterns.creational;

public class BuilderDesignPattern {
    public static void main(String[] args) {
        Burger burger1 = new Burger.BurgerBuilder("Large", "Aloo")
        .addSauce("Mint Mayo")
                .addCheese(true)
                        .addTomato(true)
                                .build();
        System.out.println(burger1);

        Burger burger2 = new Burger.BurgerBuilder("Small", "Chicken Tikki")
                .addCheese(true)
                .build();

        System.out.println(burger2);
    }
}

class Burger{
    private String size;            //mandatory
    private String patty;           //mandatory
    private String sauce;           //mandatory
    private boolean cheese;         //Optional
    private boolean tomato;         //Optional

    private Burger(BurgerBuilder builder){
        this.size = builder.size;
        this.patty = builder.patty;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.tomato = builder.tomato;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "size='" + size + '\'' +
                ", patty='" + patty + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese=" + cheese +
                ", tomato=" + tomato +
                '}';
    }

    public static class BurgerBuilder{
        private String size;            //mandatory
        private String patty;           //mandatory
        private String sauce = "Tomato Sauce";           //Default Value
        private boolean cheese;         //Optional  (Defaults to False)
        private boolean tomato;         //Optional (Defaults to False)

        public BurgerBuilder(String size, String patty){
            this.size = size;
            this.patty = patty;
        }

        public BurgerBuilder addSauce(String sauce){
            this.sauce = sauce;
            return this;
        }

        public BurgerBuilder addCheese(boolean cheese){
            this.cheese = cheese;
            return this;
        }

        public BurgerBuilder addTomato(boolean tomato){
            this.tomato = tomato;
            return this;
        }

        public Burger build(){
            return new Burger(this);
        }
    }
}
