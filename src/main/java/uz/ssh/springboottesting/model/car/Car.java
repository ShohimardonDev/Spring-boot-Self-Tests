package uz.ssh.springboottesting.model.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String brand;
    private String model;
    private EngineType engineType;
    private int year;
    private String plateNumber;
}
