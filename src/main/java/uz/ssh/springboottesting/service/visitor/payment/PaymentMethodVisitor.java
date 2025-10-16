package uz.ssh.springboottesting.service.visitor.payment;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */ // The "Visitor" interface
public interface PaymentMethodVisitor {
    void visit(CreditCardPayment creditCardPayment);

    void visit(PayPalPayment payPalPayment);

    void visit(CryptoPayment cryptoPayment);
}
