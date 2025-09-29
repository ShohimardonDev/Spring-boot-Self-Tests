package uz.ssh.springboottesting.service.command.telegram.state;

import uz.ssh.springboottesting.service.command.telegram.BotContext;
import uz.ssh.springboottesting.service.command.telegram.commands.SendMessageCommand;

public class IdleState implements BotState {
    @Override
    public void handle(BotContext context, String input) {
        // Ask user for name
        new SendMessageCommand(context.getBotService(), context.getChatId(),
            "Hi! What's your name?").execute();

        // Transition to next state
        context.nextState(new WaitingForNameState());
    }
}
