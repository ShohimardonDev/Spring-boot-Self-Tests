package uz.ssh.springboottesting.service.command.telegram.state;

public class WaitingForNameState implements BotState {
    @Override
    public void handle(BotContext context, String input) {
        String name = input;
        new SendMessageCommand(context.getBotService(), context.getChatId(),
            "Nice to meet you, " + name + "! How old are you?").execute();

        context.nextState(new WaitingForAgeState(name));
    }
}
