package uz.ssh.springboottesting.service.command.bank;

public class BankService {
    public void transfer(String from, String to, double amount) {
        System.out.printf("Transferred %.2f from %s to %s%n", amount, from, to);
    }
}