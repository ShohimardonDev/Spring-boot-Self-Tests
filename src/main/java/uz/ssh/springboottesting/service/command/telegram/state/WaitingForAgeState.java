package uz.ssh.springboottesting.service.command.telegram.state;

import lombok.RequiredArgsConstructor;
import uz.ssh.springboottesting.service.command.telegram.BotContext;
import uz.ssh.springboottesting.service.command.telegram.commands.SendMessageCommand;

@RequiredArgsConstructor
public class WaitingForAgeState implements BotState {
    private final String name;

    @Override
    public void handle(BotContext context, String input) {
        int age;
        try {
            age = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            new SendMessageCommand(context.getBotService(), context.getChatId(),
                "Please enter a valid number for age.").execute();
            return;
        }

        new SendMessageCommand(context.getBotService(), context.getChatId(),
            "Got it! Name: " + name + ", Age: " + age).execute();

        context.nextState(new IdleState()); // back to idle
    }
}
