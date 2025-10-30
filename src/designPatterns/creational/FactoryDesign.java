package designPatterns.creational;

public class FactoryDesign {
    // Example of Payment Service Methods using Factory Class to segregate Payments
}

interface Payment{
    public void process();
}

class CreditCardPayment implements Payment{
    @Override
    public void process(){
        System.out.println("Credit Cards Payment is called...");
    }
}

class PaypalPayment implements Payment{
    public void process(){
        System.out.println("Paypal Method is called...");
    }
}

class PaymentFactory {
    public static Payment getPaymentMethod(String type){
        switch (type.toLowerCase()){
            case "creditcard" :
                return new CreditCardPayment();
            case "paypal" :
                return new PaypalPayment();
            default :
                throw new IllegalArgumentException("Unknown Payment type : " + type);
        }
    }
}

class PaymentService{
    public void makePayment(String type){
        Payment payment = PaymentFactory.getPaymentMethod(type);
        payment.process();
    }
}

class PaymentClient{
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.makePayment("CreditCard");
    }
}