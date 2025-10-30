package designPatterns.behavioral;

public class StrategyDesignPattern {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment("1342534564674132"));
        paymentContext.payAmount(1000);

        paymentContext.setPaymentStrategy(new PaypalPayment("johnSnow@example.com"));
        paymentContext.payAmount(500);

        paymentContext.setPaymentStrategy(new UPIPayement("asdasd@ybl"));
        paymentContext.payAmount(750);
    }
}

//Strategy Interface
interface PaymentStrategy{
    void pay(int amount);
}

//Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber){
        this.cardNumber = cardNumber;
    }

    /**
     * @param amount
     */
    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Credit card ending with " +
                cardNumber.substring(cardNumber.length() - 4));
    }
}

class PaypalPayment implements PaymentStrategy {
    private String email;

    public PaypalPayment(String email){
        this.email = email;
    }

    /**
     * @param amount
     */
    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using Paypal account: " + email);

    }
}

class UPIPayement implements PaymentStrategy{
    private String upiID;

    public UPIPayement(String unpiID){
        this.upiID = upiID;
    }

    /**
     * @param amount
     */
    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using UPI ID " + upiID);
    }
}

//context Class for Payments
class PaymentContext{
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void payAmount(int amount) {
        paymentStrategy.pay(amount);
    }
}


