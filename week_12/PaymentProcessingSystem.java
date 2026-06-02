package week_12;

public class PaymentProcessingSystem {

    public static void main(String[] args) {
        // Logger for payment status
        PaymentLogger logger = new PaymentLogger();

        // Processor handles payment flow
        PaymentProcessor processor = new PaymentProcessor(logger);

        // Choose payment method
        PaymentMethod method = new CreditCard();

        double amount = 1000;

        // Process payment
        processor.process(method, amount);
    }
}


// Base contract for all payment methods 
interface PaymentMethod {
    void pay(double amount);
}


// Handles logging payment status
class PaymentLogger {
    void log() {
        System.out.println("Payment Success.");
    }
}

// Handles payment execution 
class PaymentProcessor {

    private PaymentLogger logger;

    PaymentProcessor(PaymentLogger logger) {
        this.logger = logger;
    }

    void process(PaymentMethod pm, double amount) {
        System.out.println("Payment in process...");
        pm.pay(amount);
        logger.log();
    }
}

// Credit card payment method
class CreditCard implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Successfully paid " + amount + " using Credit Card.");
    }
}

// PayPal payment method
class Paypal implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Successfully paid " + amount + " using PayPal.");
    }
}


// Stripe payment method
class Stripe implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Successfully paid " + amount + " using Stripe.");
    }
}