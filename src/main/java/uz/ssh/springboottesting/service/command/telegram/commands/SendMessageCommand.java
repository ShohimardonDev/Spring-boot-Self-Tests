package uz.ssh.springboottesting.service.command.telegram.commands;

import lombok.RequiredArgsConstructor;
import uz.ssh.springboottesting.service.command.Command;
import uz.ssh.springboottesting.service.command.telegram.BotService;

@RequiredArgsConstructor
public class SendMessageCommand implements Command {
    private final BotService botService;
    private final Long chatId;
    private final String message;

    @Override
    public void execute() {
        botService.sendMessage(chatId, message);
    }
}
