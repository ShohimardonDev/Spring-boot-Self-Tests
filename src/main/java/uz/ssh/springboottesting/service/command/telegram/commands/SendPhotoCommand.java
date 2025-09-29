package uz.ssh.springboottesting.service.command.telegram.commands;

import lombok.RequiredArgsConstructor;
import uz.ssh.springboottesting.service.command.Command;
import uz.ssh.springboottesting.service.command.telegram.BotService;

@RequiredArgsConstructor
public class SendPhotoCommand implements Command {
    private final BotService botService;
    private final Long chatId;
    private final String photoUrl;

    @Override
    public void execute() {
        botService.sendPhoto(chatId, photoUrl);
    }
}
