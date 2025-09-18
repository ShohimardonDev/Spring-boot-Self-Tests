package uz.ssh.springboottesting.service.validation.strategy;

import uz.ssh.springboottesting.constant.enums.EngineType;
import uz.ssh.springboottesting.model.car.Car;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
public interface CarEngineValidationStrategy {

    void validate(Car car);

    EngineType getEngineType();
}
