package uz.ssh.springboottesting.service.visitor.payment;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */ // Concrete Visitor: Calculate Fees
public class FeeCalculator implements PaymentMethodVisitor {
    @Override
    public void visit(CreditCardPayment creditCardPayment) {
        double fee = creditCardPayment.amount * 0.03;  // 3% fee for Credit Card
        System.out.println("Fee for Credit Card Payment: " + fee);
    }

    @Override
    public void visit(PayPalPayment payPalPayment) {
        double fee = payPalPayment.amount * 0.02;  // 2% fee for PayPal
        System.out.println("Fee for PayPal Payment: " + fee);
    }

    @Override
    public void visit(CryptoPayment cryptoPayment) {
        double fee = cryptoPayment.amount * 0.00000111;  // 5% fee for Crypto Payment
        System.out.println("Fee for Crypto Payment: " + fee);
    }
}
