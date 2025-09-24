package uz.ssh.springboottesting.service.cor;

class PayPalHandler extends PaymentHandler {
    protected boolean process(String type, double amount) {
        if ("PAYPAL".equalsIgnoreCase(type)) {
            System.out.println("Processing PAYPAL payment: " + amount);
            return true;
        }
        return false;
    }
}