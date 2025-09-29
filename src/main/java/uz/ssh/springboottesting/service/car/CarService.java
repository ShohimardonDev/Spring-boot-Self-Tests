package uz.ssh.springboottesting.service.car;


import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.ssh.springboottesting.model.car.dto.CarDTO;

 public interface CarService {

    /**
    * Save a car.
    *
    * @param carDTO the entity to save.
    * @return the persisted entity.
    */
    CarDTO save(CarDTO carDTO);

    /**
    * Update a car.
    *
    * @param carDTO the entity to update.
    * @return the persisted entity.
    */
    CarDTO update(CarDTO carDTO);

    /**
    * Partially update a car.
    *
    * @param carDTO the entity to update partially.
    * @return the persisted entity.
    */
    Optional<CarDTO> partialUpdate(CarDTO carDTO);

    /**
    * Get all the cars.
    *
    * @return the list of entities.
    */
    List<CarDTO> findAll();

    /**
    * Get all the cars with pagination.
    *
    * @param pageable the pagination information.
    * @return the list of entities.
    */
    Page<CarDTO> findAll(Pageable pageable);

    /**
    * Get the "id" car.
    *
    * @param id the id of the entity.
    * @return the entity.
    */
    Optional<CarDTO> findOne(String id);

    /**
    * Delete the "id" car.
    *
    * @param id the id of the entity.
    */
    void delete(String id);

    /**
    * Count total number of cars.
    *
    * @return the total count.
    */
    long count();

    /**
    * Check if a car exists by id.
    *
    * @param id the id to check.
    * @return true if exists, false otherwise.
    */
    boolean existsById(String id);

    /**
    * Delete multiple cars by their ids.
    *
    * @param ids the list of ids to delete.
    */
    void deleteByIds(List<String> ids);

}
