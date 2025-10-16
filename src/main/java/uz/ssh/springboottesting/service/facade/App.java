package uz.ssh.springboottesting.service.facade;

public class App {
    public static void main(String[] args) {
        OrderFacade facade = new OrderFacade();
        facade.placeOrder("Laptop", "CreditCard");
    }
}
