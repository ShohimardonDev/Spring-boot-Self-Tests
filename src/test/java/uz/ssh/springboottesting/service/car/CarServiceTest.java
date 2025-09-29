package uz.ssh.springboottesting.service.car.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import uz.ssh.springboottesting.service.car.dto.CarDTO;
import uz.ssh.springboottesting.service.car.entity.Car;
import uz.ssh.springboottesting.service.car.mapper.CarMapper;
import uz.ssh.springboottesting.service.car.repository.CarRepository;
import uz.ssh.springboottesting.service.car.service.impl.CarServiceImpl;

 public class CarServiceTest 
{

    @Mock
    private CarRepository carRepository;

    @Mock
    private CarMapper carMapper;

    @InjectMocks
    private CarServiceImpl carService;

    private Car car;
    private CarDTO carDTO;
    private List<Car> carList;
    private String testId;

    @BeforeEach
    void setUp()
{
        // Setup test data
        testId = "test-id";

        car = new Car();
        // Set id directly on the entity using reflection or direct field access if needed
        // For test purposes, we'll mock the responses instead of relying on actual entity getter methods

        carDTO = new CarDTO();
        carDTO.setId(testId);

        carList = new ArrayList<>();
        carList.add(car);
    }

    @Test
    void testSave()
{
        // Arrange
        when(carMapper.toEntity(any(CarDTO.class))).thenReturn(car);
        when(carRepository.save(any(Car.class))).thenReturn(car);
        when(carMapper.toDto(any(Car.class))).thenReturn(carDTO);

        // Act
        CarDTO result = carService.save(carDTO);

        // Assert
        assertThat(result).isNotNull();
        verify(carRepository).save(any(Car.class));
        verify(carMapper).toDto(any(Car.class));
    }

    @Test
    void testFindAll()
{
        // Arrange
        List<CarDTO> dtoList = new ArrayList<>();
        dtoList.add(carDTO);

        when(carRepository.findAll()).thenReturn(carList);

        // Stub the individual entity mapping instead of the list mapping
        // This correctly handles the stream().map() call in the service
        when(carMapper.toDto(any(Car.class))).thenReturn(carDTO);

        // Act
        List<CarDTO> result = carService.findAll();

        // Assert
        assertThat(result).isNotNull().hasSize(1);
        verify(carRepository).findAll();
    }

    @Test
    void testFindOne()
{
        // Arrange
        when(carRepository.findById(any())).thenReturn(Optional.of(car));
        when(carMapper.toDto(any(Car.class))).thenReturn(carDTO);

        // Act
        CarDTO result = carService.findOne(testId);

        // Assert
        assertThat(result).isNotNull();
        verify(carRepository).findById(any());
    }

    @Test
    void testDelete()
{
        // Arrange
        doNothing().when(carRepository).deleteById(any());

        // Act
        carService.delete(testId);

        // Assert
        verify(carRepository).deleteById(any());
    }
}
