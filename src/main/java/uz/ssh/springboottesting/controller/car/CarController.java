package uz.ssh.springboottesting.controller.car;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.ssh.springboottesting.model.car.Car;
import uz.ssh.springboottesting.service.car.CarService;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping
    public Car save() {
        return carService.save();
    }

}
