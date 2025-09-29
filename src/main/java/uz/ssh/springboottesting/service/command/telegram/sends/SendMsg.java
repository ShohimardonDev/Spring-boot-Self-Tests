package uz.ssh.springboottesting.service.command.telegram.sends;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.ssh.springboottesting.service.command.Command;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendMsg implements Command {
    private String chatId;
    private String text;

    @Override
    public void execute() {

//        Bot.execute(new SendMsg(chatId, text));

    }
}
