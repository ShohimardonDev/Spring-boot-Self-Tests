package uz.ssh.springboottesting.service.car.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.ssh.springboottesting.mapper.car.CarMapper;
import uz.ssh.springboottesting.model.car.dto.CarDTO;
import uz.ssh.springboottesting.repository.car.CarRepository;
import uz.ssh.springboottesting.service.car.CarService;

@Transactional
@Service
 public class CarServiceImpl implements CarService 
{

    private final Logger log = LoggerFactory.getLogger(CarServiceImpl.class);

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarServiceImpl(CarRepository carRepository, CarMapper carMapper)
{
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDTO save(CarDTO carDTO)
{
        log.debug("Request to save Car : {}", carDTO);
        Car car = carMapper.toEntity(carDTO);
        car = carRepository.save(car);
        return carMapper.toDto(car);
    }

    @Override
    public CarDTO update(CarDTO carDTO)
{
        log.debug("Request to update Car : {}", carDTO);
        Car car = carMapper.toEntity(carDTO);
        car = carRepository.save(car);
        return carMapper.toDto(car);
    }

    @Override
    public Optional<CarDTO> partialUpdate(CarDTO carDTO)
{
        log.debug("Request to partially update Car : {}", carDTO);

        return carRepository
            .findById(carDTO.getId())
            .map(existingCar -> {
                carMapper.partialUpdate(existingCar, carDTO);
                return existingCar;
            })
            .map(carRepository::save)
            .map(carMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CarDTO> findAll()
{
        log.debug("Request to get all Cars");
        return carRepository.findAll().stream()
            .map(carMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<CarDTO> findAll(Pageable pageable)
{
        log.debug("Request to get all Cars with pagination");
        return carRepository.findAll(pageable)
            .map(carMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CarDTO> findOne(String id)
{
        log.debug("Request to get Car : {}", id);
        return carRepository.findById(id)
            .map(carMapper::toDto);
    }

    @Override
    public void delete(String id)
{
        log.debug("Request to delete Car : {}", id);
        carRepository.deleteById(id);
    }

    @Override
    public void deleteByIds(List<String> ids)
{
        log.debug("Request to delete Cars by ids : {}", ids);
        carRepository.deleteAllById(ids);
    }

    @Override
    @Transactional(readOnly = true)
    public long count()
{
        log.debug("Request to count Cars");
        return carRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(String id)
{
        log.debug("Request to check if Car exists : {}", id);
        return carRepository.existsById(id);
    }

}
