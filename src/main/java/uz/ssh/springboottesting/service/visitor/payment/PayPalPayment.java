package uz.ssh.springboottesting.service.visitor.payment;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
public class PayPalPayment extends PaymentMethod {

    public PayPalPayment(double amount) {
        this.amount = amount;
    }

    @Override
    public void accept(PaymentMethodVisitor visitor) {
        visitor.visit(this);
    }
}
