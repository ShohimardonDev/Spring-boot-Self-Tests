package uz.ssh.springboottesting.service.visitor.payment;

public class PaymentProcessing {
    public static void main(String[] args) {
        // Create different types of payments
        PaymentMethod creditCardPayment = new CreditCardPayment(1000.0);  // $1000 CreditCard
        PaymentMethod payPalPayment = new PayPalPayment(500.0);  // $500 PayPal
        PaymentMethod cryptoPayment = new CryptoPayment(1500.0);  // $1500 Crypto

        // Create visitors
        PaymentMethodVisitor validator = new PaymentValidator();
        PaymentMethodVisitor feeCalculator = new FeeCalculator();

        // Apply validation and fee calculation
        System.out.println("---- Validating Payments ----");
        creditCardPayment.accept(validator);
        payPalPayment.accept(validator);
        cryptoPayment.accept(validator);

        System.out.println("---- Calculating Fees ----");
        creditCardPayment.accept(feeCalculator);
        payPalPayment.accept(feeCalculator);
        cryptoPayment.accept(feeCalculator);
    }
}
