package uz.ssh.springboottesting.service.visitor.payment;

public class PaymentValidator implements PaymentMethodVisitor {
    @Override
    public void visit(CreditCardPayment creditCardPayment) {
        System.out.println("Validating Credit Card Payment of " + creditCardPayment.amount);
    }

    @Override
    public void visit(PayPalPayment payPalPayment) {
        System.out.println("Validating PayPal Payment of " + payPalPayment.amount);
    }

    @Override
    public void visit(CryptoPayment cryptoPayment) {
        System.out.println("Validating Crypto Payment of " + cryptoPayment.amount);
    }
}