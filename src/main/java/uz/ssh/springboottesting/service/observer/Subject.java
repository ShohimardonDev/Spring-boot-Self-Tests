package uz.ssh.springboottesting.service.observer;

import org.springframework.stereotype.Component;


/**
 * @author Shokhimardon
 * @since 9/21/25
 */
@Component
public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
