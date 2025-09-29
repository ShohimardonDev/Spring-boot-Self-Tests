package uz.ssh.springboottesting.service.command.telegram.commands;

import lombok.RequiredArgsConstructor;
import uz.ssh.springboottesting.service.command.Command;
import uz.ssh.springboottesting.service.command.telegram.BotService;

import java.util.List;

@RequiredArgsConstructor
public class SendMessageWithButtonsCommand implements Command {
    private final BotService botService;
    private final Long chatId;
    private final String message;
    private final List<Button> buttons;

    @Override
    public void execute() {
        botService.sendMessageWithButtons(chatId, message, buttons);
    }

    @RequiredArgsConstructor
    public static class Button {
        public final String text;     // visible to user
        public final String callback; // callback data
    }
}
