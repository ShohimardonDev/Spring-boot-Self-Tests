package uz.ssh.springboottesting.service.command.telegram.action;

import uz.ssh.springboottesting.service.command.telegram.BotContext;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
@FunctionalInterface
public interface BotAction {
    void execute(BotContext ctx);
}

