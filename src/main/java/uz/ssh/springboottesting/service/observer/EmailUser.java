package uz.ssh.springboottesting.service.observer;

import org.springframework.stereotype.Component;

/**
 * @author Shokhimardon
 * @since 9/21/25
 */
@Component
public class EmailUser implements Observer {
    private final String email = "temp@gmail.com";

    @Override
    public void update(String weather) {

        System.out.println("weather = " + weather + "\n" + email);
    }
}
