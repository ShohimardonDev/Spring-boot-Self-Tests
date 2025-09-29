package uz.ssh.springboottesting.model.car.dto;


import jakarta.validation.constraints.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
 public class CarDTO implements Serializable 
{

    private static final long serialVersionUID = 1L;

    private String brand;

    private String model;

    private EngineType engineType;

    private Integer year;

    private String plateNumber;


}
