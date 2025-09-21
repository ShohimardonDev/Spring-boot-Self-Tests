package uz.ssh.springboottesting.service.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Shokhimardon
 * @since 9/21/25
 */
@Component
public class WeatherStation implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String weather = "";

    public void setWeather(String newWeather) {
        this.weather = newWeather;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(weather);
        }

    }
}
