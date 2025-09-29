package uz.ssh.springboottesting.service.command.telegram.state;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.service.command.telegram.BotContext;
import uz.ssh.springboottesting.service.command.telegram.action.BotAction;
import uz.ssh.springboottesting.service.command.telegram.commands.SendMessageWithButtonsCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class WaitingForConfirmationState implements BotState {

    private final Map<String, BotAction> actions = new HashMap<>();

    @PostConstruct
    public void ConfirmState() {
        register("confirm_yes", this::confirm);
        register("confirm_no", this::cancel);
    }

    private void register(String key, BotAction action) {
        actions.put(key, action);
    }

    @Override
    public void handle(BotContext context, String input) {
        // Send a question with Yes/No buttons
        new SendMessageWithButtonsCommand(
                context.getBotService(),
                context.getChatId(),
                "Do you confirm this action?",
                Arrays.asList(
                        new SendMessageWithButtonsCommand.Button("Yes ✅", "confirm_yes"),
                        new SendMessageWithButtonsCommand.Button("No ❌", "confirm_no")
                )
        ).execute();
    }

    @Override
    public void handleButton(BotContext context, String callbackData) {
        actions.get(callbackData).execute(context);
        context.setState(new IdleState());
    }

    private void confirm(BotContext context) {
        context.getBotService().sendMessage(context.getChatId(), "✅ Confirmed!");
    }

    private void cancel(BotContext context) {
        context.getBotService().sendMessage(context.getChatId(), "❌ Cancelled!");
    }

}
