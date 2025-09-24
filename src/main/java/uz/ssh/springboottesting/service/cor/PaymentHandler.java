package uz.ssh.springboottesting.service.cor;

/**
 * @author Shokhimardon
 * @since 9/22/25
 */
abstract class PaymentHandler {
    private PaymentHandler next;

    public PaymentHandler setNext(PaymentHandler next) {
        this.next = next;
        return next;
    }

    public void handle(String type, double amount) {
        if (!process(type, amount) && next != null) {
            next.handle(type, amount);
        }
    }

    protected abstract boolean process(String type, double amount);
}
