package uz.ssh.springboottesting.service.validation;

import uz.ssh.springboottesting.model.car.Car;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
public interface CarEngineValidator {
    void validate(Car car);
}
