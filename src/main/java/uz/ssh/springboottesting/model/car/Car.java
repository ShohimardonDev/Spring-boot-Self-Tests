package uz.ssh.springboottesting.model.car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.ssh.springboottesting.constant.enums.EngineType;

/**
 * @author Shokhimardon
 * @since 9/16/25
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String brand;
    private String model;
    private EngineType engineType;
    private int year;
    private String plateNumber;
}
