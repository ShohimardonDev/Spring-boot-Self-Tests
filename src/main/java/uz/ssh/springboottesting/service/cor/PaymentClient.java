package uz.ssh.springboottesting.service.cor;

public class PaymentClient {
    public static void main(String[] args) {
        PaymentHandler handler = new CreditCardHandler();
        handler.setNext(new PayPalHandler())
                .setNext(new CreditCardHandler());

        handler.handle("PAYPAL", 250.0);
    }
}