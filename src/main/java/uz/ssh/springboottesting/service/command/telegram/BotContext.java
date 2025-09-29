package uz.ssh.springboottesting.service.command.telegram;

import lombok.Getter;
import lombok.Setter;
import uz.ssh.springboottesting.service.command.telegram.state.BotState;

@Getter
@Setter
public class BotContext {
    private final Long chatId;
    private BotState state;
    private final BotService botService;

    public BotContext(Long chatId, BotService botService) {
        this.chatId = chatId;
        this.botService = botService;
    }

    public void nextState(BotState next) {
        this.state = next;
    }
}
