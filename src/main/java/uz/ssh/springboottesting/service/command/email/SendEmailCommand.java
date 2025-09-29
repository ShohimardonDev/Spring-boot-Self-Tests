package uz.ssh.springboottesting.service.command.email;

import uz.ssh.springboottesting.service.command.Command;

/**
 * @author Shokhimardon
 * @since 9/25/25
 */
public class SendEmailCommand implements Command {
    private final EmailService emailService;
    private final String email;

    public SendEmailCommand(EmailService emailService, String email) {
        this.emailService = emailService;
        this.email = email;
    }

    @Override
    public void execute() {
        emailService.send(email);
    }
}
