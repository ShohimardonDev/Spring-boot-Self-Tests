package uz.ssh.springboottesting.service.command.bank;

import uz.ssh.springboottesting.service.command.Command;

import java.util.LinkedList;
import java.util.Queue;

public class TransactionProcessor {
    private final Queue<Command> history = new LinkedList<>();

    public void submit(Command command) {
        history.add(command);
        command.execute();
    }

    public void rollbackLast() {
        if (!history.isEmpty()) history.poll().undo();
    }
}