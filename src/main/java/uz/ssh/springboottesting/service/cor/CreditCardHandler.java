package uz.ssh.springboottesting.service.cor;

class CreditCardHandler extends PaymentHandler {
    protected boolean process(String type, double amount) {
        if ("CREDIT".equalsIgnoreCase(type)) {
            System.out.println("Processing CREDIT payment: " + amount);
            return true;
        }
        return false;
    }
}