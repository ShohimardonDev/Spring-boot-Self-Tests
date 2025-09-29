package uz.ssh.springboottesting.service.command.telegram;

import org.springframework.stereotype.Service;
import uz.ssh.springboottesting.service.command.telegram.commands.SendMessageWithButtonsCommand;
import uz.ssh.springboottesting.service.command.telegram.sends.SendMsg;
import uz.ssh.springboottesting.service.command.telegram.sends.SendVideo;

import java.util.List;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
@Service
public class BotService {
    public SendMsg sayHello() {
        return new SendMsg("ssh_dev", "Hello World");
    }

    public SendVideo sendVideo() {
        return new SendVideo("ssh_dev", "Hello World");
    }

    public void sendMessage(Long chatId, String message) {
        System.out.printf("➡️ Sending message to %d: %s%n", chatId, message);
        // Call Telegram API (e.g., RestTemplate or HttpClient)
    }

    public void sendPhoto(Long chatId, String photoUrl) {
        System.out.printf("➡️ Sending photo to %d: %s%n", chatId, photoUrl);
        // Telegram sendPhoto API call
    }

    public void sendMessageWithButtons(Long chatId, String text,
                                       List<SendMessageWithButtonsCommand.Button> buttons) {
        System.out.printf("➡️ Sending message to %d: %s%n", chatId, text);
        System.out.println("Buttons:");
        for (SendMessageWithButtonsCommand.Button btn : buttons) {
            System.out.printf("   [%s] callback=%s%n", btn.text, btn.callback);
        }
        // Example: Use Telegram API (InlineKeyboardMarkup)
    }
}
