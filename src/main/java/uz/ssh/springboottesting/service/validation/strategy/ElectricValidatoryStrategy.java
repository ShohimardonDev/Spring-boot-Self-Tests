package uz.ssh.springboottesting.service.validation.strategy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.constant.enums.EngineType;
import uz.ssh.springboottesting.model.car.Car;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
@Component
@Slf4j
public class ElectricValidatoryStrategy implements CarEngineValidationStrategy {
    @Override
    public void validate(Car car) {
      log.info("Car engine validation started");

    }

    @Override
    public EngineType getEngineType() {
        return EngineType.ELECTRIC;
    }
}
