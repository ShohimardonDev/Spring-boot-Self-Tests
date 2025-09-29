package uz.ssh.springboottesting.service.command.order;

import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.service.command.Command;

@Component
public class CommandDispatcher {
    public void dispatch(Command cmd) {
        cmd.execute();
    }
}