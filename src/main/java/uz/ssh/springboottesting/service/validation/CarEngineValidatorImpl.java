package uz.ssh.springboottesting.service.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import uz.ssh.springboottesting.constant.enums.EngineType;
import uz.ssh.springboottesting.model.car.Car;
import uz.ssh.springboottesting.service.validation.strategy.CarEngineValidationStrategy;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CarEngineValidatorImpl implements CarEngineValidator, InitializingBean {
    private final Map<EngineType, CarEngineValidationStrategy> strategies = new EnumMap<>(EngineType.class);
    private final ApplicationContext applicationContext;

    @Override
    public void validate(Car car) {
        log.info("Car engine validation started");
        var carEngineValidatoryStrategy = strategies.get(car.getEngineType());
        carEngineValidatoryStrategy.validate(car);

    }


    @Override
    public void afterPropertiesSet() {
        applicationContext.getBeansOfType(CarEngineValidationStrategy.class)
                .forEach((beanName, carEngineValidationStrategy) -> {
                    strategies.put(carEngineValidationStrategy.getEngineType(), carEngineValidationStrategy);
                });
    }
}
