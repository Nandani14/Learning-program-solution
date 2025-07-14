// Adapter Pattern Example - Unifying different payment gateways

// Step 1: Target interface (used by your app)
interface PaymentProcessor {
    void pay(int amount);
}

// Step 2: Adaptee class 1 - PayPal
class PayPal {
    public void makePayment(int amountInRs) {
        System.out.println("Payment of ₹" + amountInRs + " done via PayPal.");
    }
}

// Step 3: Adaptee class 2 - Stripe
class Stripe {
    public void processStripePayment(int value) {
        System.out.println("Payment of ₹" + value + " done via Stripe.");
    }
}

// Step 4: Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    public void pay(int amount) {
        paypal.makePayment(amount);
    }
}

// Step 5: Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    public void pay(int amount) {
        stripe.processStripePayment(amount);
    }
}

// Step 6: Main application using the adapters
public class AdapterPattern {
    public static void main(String[] args) {
        System.out.println("Daksh is paying using PayPal:");
        PaymentProcessor dakshPayment = new PayPalAdapter(new PayPal());
        dakshPayment.pay(500);

        System.out.println("\nShikha is paying using Stripe:");
        PaymentProcessor shikhaPayment = new StripeAdapter(new Stripe());
        shikhaPayment.pay(800);
    }
}

