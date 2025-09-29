package uz.ssh.springboottesting.service.command.telegram.state;

import uz.ssh.springboottesting.service.command.telegram.BotContext;

public interface BotState {
    void handle(BotContext context, String input);

    default void handleButton(BotContext context, String callbackData) {
        // no-op
    }
}
