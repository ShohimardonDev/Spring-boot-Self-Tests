package uz.ssh.springboottesting.service.facade;

/**
 * @author Shokhimardon
 * @since 10/16/25
 */
public class NotificationService {
    void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}
