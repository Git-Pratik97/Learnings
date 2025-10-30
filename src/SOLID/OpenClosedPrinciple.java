package SOLID;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        Payment creditCardPayment = new CreditCardPayment();
        Payment paypalPayment = new PaypalPayment();

        paymentProcessor.processPayment(creditCardPayment);
        paymentProcessor.processPayment(paypalPayment);
    }
}

abstract class Payment{
    public abstract void process();
}

class CreditCardPayment extends Payment{
    public void process(){
        System.out.println("Credit Card Payment...");
    }
}

class PaypalPayment extends Payment{
    public void process(){
        System.out.println("Paypal Payment Process...");
    }
}

class GooglePay extends Payment{
    public void process(){
        System.out.println("Google Pay Payment Process");
    }
}

class PaymentProcessor{
    public void processPayment(Payment payment){
        payment.process();
    }
}
