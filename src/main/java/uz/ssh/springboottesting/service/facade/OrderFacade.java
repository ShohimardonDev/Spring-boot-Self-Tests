package uz.ssh.springboottesting.service.facade;

public class OrderFacade {
    private final PaymentService paymentService = new PaymentService();
    private final InventoryService inventoryService = new InventoryService();
    private final NotificationService notificationService = new NotificationService();

    public void placeOrder(String product, String paymentType) {
        System.out.println("Starting order process...");
        paymentService.processPayment(paymentType);
        inventoryService.updateStock(product);
        notificationService.sendEmail("Your order for " + product + " was successful!");
        System.out.println("Order completed!");
    }
}
