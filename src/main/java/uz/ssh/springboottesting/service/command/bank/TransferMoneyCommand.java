package uz.ssh.springboottesting.service.command.bank;

import uz.ssh.springboottesting.service.command.Command;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
public class TransferMoneyCommand implements Command {
    private final BankService bankService;
    private final String from;
    private final String to;
    private final double amount;

    public TransferMoneyCommand(BankService bankService, String from, String s, double amount) {
        this.bankService = bankService;
        this.from = from;
        to = s;
        this.amount = amount;
    }

    @Override
    public void execute() {
        bankService.transfer(from, to, amount);

    }

    @Override
    public void undo() {
        bankService.transfer(to, from, amount);
    }
}
