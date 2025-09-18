package uz.ssh.springboottesting.service.car;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.ssh.springboottesting.constant.enums.EngineType;
import uz.ssh.springboottesting.model.car.Car;
import uz.ssh.springboottesting.service.validation.CarEngineValidator;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarEngineValidator carEngineValidator;
    private final Faker faker;

    public Car save() {
        var car = new Car();

        car.setBrand(faker.company().name());
        car.setModel(faker.letterify("Model-???"));
        car.setEngineType(EngineType.values()[faker.random().nextInt(EngineType.values().length)]);
        car.setYear(faker.number().numberBetween(1995, 2025));
        car.setPlateNumber(faker.bothify("??-####"));
        carEngineValidator.validate(car);
        return car;
    }


}
